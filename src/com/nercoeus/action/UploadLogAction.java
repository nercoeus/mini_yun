package com.nercoeus.action;

import com.nercoeus.dao.root.Download_log;
import com.nercoeus.service.DownloadService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

public class UploadLogAction extends ActionSupport{

    private String username;
    private String download_user_name;
    private String download_file_name;
    private Date download_time;
    private DownloadService downloadService;

    public UploadLogAction(){

    }

    public void setDownload_time(Date download_time) {
        this.download_time = download_time;
    }

    public Date getDownload_time() {
        return download_time;
    }

    public String getDownload_user_name() {
        return download_user_name;
    }

    public String getDownload_file_name() {
        return download_file_name;
    }

    public void setDownload_user_name(String download_user_name) {
        this.download_user_name = download_user_name;
    }

    public void setDownload_file_name(String download_file_name) {
        this.download_file_name = download_file_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setDownloadService(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    public DownloadService getDownloadService() {
        return downloadService;
    }

    public String execute() throws Exception {
        List<Download_log> list;
        try {
            String username = this.username;
            String username2 = (String)ActionContext.getContext().getSession().get("user_name");
            if (username2!=null||"".equals(username2)){
                username = username2;
            }
            if (username == null || "".equals(username)) {
                return "input";
            }

            this.username = username;
            list = this.downloadService.getUploadLog(this);
        }
        catch (Exception var3) {
            var3.printStackTrace();
            return "input";
        }

        ServletActionContext.getRequest().setAttribute("List", list);
        return "success";

    }
    public String delete() throws Exception{
        try {
            this.downloadService.deleteUploadByLog(this);
        }catch (Exception var3) {
            var3.printStackTrace();
            return "input";
        }
        ServletActionContext.getRequest().setAttribute("username", this.download_user_name);
        return "success";
    }
}



