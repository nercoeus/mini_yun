//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.action;

import com.nercoeus.dao.root.Upload;
import com.nercoeus.service.DownloadService;
import com.nercoeus.service.FileService;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Date;
import javax.servlet.ServletOutputStream;
import org.apache.struts2.ServletActionContext;

public class DownloadAction extends ActionSupport implements Serializable {
    private int id;
    private String filename;
    private FileService service;
    private DownloadService downloadService;

    public DownloadAction() {
    }

    public void setService(FileService s) {
        this.service = s;
    }

    public void setDownloadService(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String execute() throws Exception {
        FileInputStream in = null;

        String var3;
        try {
            String path = this.service.findFilepathById(this.id);
            if (path != null && !"".equals(path)) {
                String username = path;
                path = File.separator + "home" + File.separator + "nercoeus" + File.separator + "Desktop" + File.separator + "upload" + File.separator + path + File.separator + this.filename;
                File file = new File(path);
                ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(this.filename, "UTF-8"));
                in = new FileInputStream(file);
                //int len = false;
                byte[] buffer = new byte[1024];
                ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();

                int len;
                while((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }

                Object var7 = null;

                Upload tempUp = new Upload();
                tempUp.setFile_name(this.filename);
                tempUp.setUpload_time(new Date());
                tempUp.setUser_name(username);
                downloadService.insertNum(tempUp);

                return (String)var7;
            }

            ServletActionContext.getRequest().setAttribute("message", "no file");
            var3 = "input";
        } catch (Exception var18) {
            var18.printStackTrace();
            var3 = "input";
            return var3;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException var17) {
                var17.printStackTrace();
            }

        }

        return var3;
    }
}
