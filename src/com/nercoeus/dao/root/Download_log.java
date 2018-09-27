package com.nercoeus.dao.root;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component("log")
@Scope("prototype")
public class Download_log {

    private String download_user_name;
    private String download_file_name;
    private Date download_time;

    public Download_log() {
    }

    public Date getDownload_time() {
        return download_time;
    }

    public void setDownload_time(Date download_time) {
        this.download_time = download_time;
    }

    public String getDownload_file_name() {
        return download_file_name;
    }

    public void setDownload_file_name(String download_file_name) {
        this.download_file_name = download_file_name;
    }

    public String getDownload_user_name() {
        return download_user_name;
    }

    public void setDownload_user_name(String download_user_name) {
        this.download_user_name = download_user_name;
    }
}
