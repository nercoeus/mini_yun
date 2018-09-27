package com.nercoeus.action;

import com.nercoeus.dao.root.Download_log;
import com.nercoeus.service.DownloadService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

public class Download_log_Action extends ActionSupport {
    private String username;
    private DownloadService downloadService;



    public Download_log_Action(){

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
            //String username = (String) ActionContext.getContext().getSession().get("username");
            String username = this.username;
            String username2 = (String)ActionContext.getContext().getSession().get("user_name");
            if (username2!=null||"".equals(username2)){
                username = username2;
            }
            if (username == null || "".equals(username)) {
                return "input";
            }

            this.username = username;
            list = this.downloadService.getDownloadLog(this);
        }
        catch (Exception var3) {
            var3.printStackTrace();
            return "input";
        }

        ServletActionContext.getRequest().setAttribute("List", list);
        return "success";

        /*

        Integer vip = (Integer)ServletActionContext.getRequest().getAttribute("isvip");
        if (vip == null) {
            vip = this.userService.isVip(this.filepath);
            ServletActionContext.getRequest().setAttribute("isvip", vip);
        }

        this.pageBean.setList(list);
        this.pageBean.setPagesize(this.pagesize);
        this.pageBean.setTotalrecord(this.fileService.countUserFiles(this));
        this.pageBean.setCurrentpage(this.currentpage);

        */
    }

}
