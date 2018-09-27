package com.nercoeus.action;

import com.nercoeus.dao.root.Download_log;
import com.nercoeus.service.DownloadService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.Date;

public class DownloadLogDeleteAction extends ActionSupport {

    private Download_log download_log;
    private String download_user_name;
    private String download_file_name;
    private Date download_time;
    private DownloadService downloadService;

    public DownloadLogDeleteAction(){

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

    public void setDownloadService(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    public DownloadService getDownloadService() {
        return downloadService;
    }


    public Download_log getDownload_log() {
        return download_log;
    }

    public void setDownload_log(Download_log download_log) {
        this.download_log = download_log;
    }


    public String execute() throws Exception{
        try {
            this.downloadService.deleteByLog(this);
        }catch (Exception var3) {
            var3.printStackTrace();
            return "input";
        }
        ServletActionContext.getRequest().setAttribute("username", download_log.getDownload_user_name());
        return "success";
    }
}
