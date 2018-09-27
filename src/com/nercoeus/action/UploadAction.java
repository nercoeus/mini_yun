//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.action;

import com.nercoeus.dao.root.Upload;
import com.nercoeus.service.FileService;
import com.nercoeus.service.UploadService;
import com.nercoeus.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadAction extends ActionSupport {
    private String username;
    private File file;
    private String fileFileName;
    private String fileContentType;
    private UserService userService;
    private FileService fileService;
    private UploadService uploadService;
    private com.nercoeus.dao.root.File f;
    private static final String thisFilePath;
    private static final int normallimit = 20000000;
    private static final int viplimit = 50000000;
    private static final int factor = 1000000;

    public UploadAction() {
    }

    public void setF(com.nercoeus.dao.root.File f) {
        this.f = f;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return this.fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return this.fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String upload() {

        String user_name = (String)ActionContext.getContext().getSession().get("user_name");
        if (user_name != null && !"".equals(user_name) && user_name.equals(this.username)) {
            Integer isVip = null;

            try {
                isVip = this.userService.isVip(user_name);
                ServletActionContext.getRequest().setAttribute("isvip", isVip);
            } catch (Exception var9) {
                var9.printStackTrace();
                ServletActionContext.getRequest().setAttribute("message", "请重新上传");
                return "success";
            }

            File thisfile = null;

            try {
                thisfile = new File(thisFilePath + File.separator + this.username, this.fileFileName);
            } catch (Exception var8) {
                ServletActionContext.getRequest().setAttribute("message", "请先选择文件！");
                return "success";
            }

            long size = this.file.length();
            if ("success".equals(this.checkFile(thisfile, thisFilePath, isVip, size))) {
                return "success";
            } else {
                Integer fileid = null;

                try {
                    FileUtils.copyFile(this.file, thisfile);
                    this.f.setTime(new Date());
                    this.f.setFilename(this.fileFileName);
                    this.f.setFilepath(this.username);
                    this.f.setFilesize(String.valueOf(size / 1024L + 1L));
                    this.f.setCanshare(0);
                    fileid = this.fileService.insertFile(this.f);
                    ServletActionContext.getRequest().setAttribute("message", "上传成功！");
                    Upload tempUp = new Upload();
                    tempUp.setFile_name(this.fileFileName);
                    tempUp.setUser_name(this.username);
                    tempUp.setUpload_time(new Date());
                    this.uploadService.insertNum(tempUp);
                    return "success";
                } catch (Exception var10) {
                    var10.printStackTrace();
                    if (thisfile.exists()) {
                        thisfile.delete();
                    }

                    if (fileid != null) {
                        ;
                    }

                    ServletActionContext.getRequest().setAttribute("message", "上传失败！请重试");
                    return "success";
                }
            }
        } else {
            return "success";
        }
    }

    private String checkFile(File thisfile, String storePath, int isVip, long size) {
        if (thisfile.exists()) {
            ServletActionContext.getRequest().setAttribute("message", "文件已存在!");
            return "success";
        } else if (size == 0L) {
            ServletActionContext.getRequest().setAttribute("message", "文件大小不能为0");
            return "success";
        } else if (isVip == 0 && size > 20000000L) {
            ServletActionContext.getRequest().setAttribute("message", "普通用户最大只能上传20Mb的文件");
            return "success";
        } else if (isVip == 1 && size > 50000000L) {
            ServletActionContext.getRequest().setAttribute("message", "VIP用户最大只能上传50Mb的文件");
            return "success";
        } else {
            return "OK";
        }
    }

    static {
        thisFilePath = File.separator + "home" + File.separator + "nercoeus" + File.separator + "Desktop" + File.separator + "upload";
    }
}
