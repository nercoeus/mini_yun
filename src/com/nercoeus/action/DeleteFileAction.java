//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.action;

import com.nercoeus.service.FileService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import org.apache.struts2.ServletActionContext;

public class DeleteFileAction extends ActionSupport {
    private int currentpage;
    private int pagesize;
    private int id;
    private FileService fileService;

    public DeleteFileAction() {
    }

    public void setFileService(FileService service) {
        this.fileService = service;
    }

    public int getCurrentpage() {
        return this.currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getPagesize() {
        return this.pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String delete() {
        System.out.println(this.id);

        try {
            String username = this.fileService.findFilepathById(this.id);
            String login_user = (String)ActionContext.getContext().getSession().get("user_name");
            String filename = this.fileService.findFilenameById(this.id);
            if (username != null && login_user.equals(username)) {
                this.fileService.deleteFileById(this.id);
                String path = new String(File.separator + "home" + File.separator + "nercoeus" + File.separator + "Desktop" + File.separator + "upload" + File.separator + login_user + File.separator + filename);
                File file = new File(path);
                if (file.exists()) {
                    file.delete();
                    return "success";
                } else {
                    ServletActionContext.getRequest().setAttribute("globalmessage", "文件不存在");
                    return "error";
                }
            } else {
                ServletActionContext.getRequest().setAttribute("globalmessage", "该文件可能不属于你");
                return "error";
            }
        } catch (Exception var6) {
            var6.printStackTrace();
            ServletActionContext.getRequest().setAttribute("globalmessage", "该文件可能不属于你");
            return "error";
        }
    }
}
