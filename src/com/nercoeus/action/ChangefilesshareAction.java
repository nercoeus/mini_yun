//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.action;

import com.nercoeus.service.FileService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class ChangefilesshareAction extends ActionSupport {
    private int currentpage;
    private int pagesize;
    private int canshare;
    private int id;
    private FileService fileService;

    public ChangefilesshareAction() {
    }

    public void setService(FileService service) {
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

    public int getCanshare() {
        return this.canshare;
    }

    public void setCanshare(int canshare) {
        this.canshare = canshare;
    }

    public String change() throws Exception {
        try {
            String username = this.fileService.findFilepathById(this.id);
            String login_user = (String)ActionContext.getContext().getSession().get("user_name");
            if (username != null && login_user.equals(username)) {
                this.fileService.changeShareById(this);
                return "success";
            } else {
                ServletActionContext.getRequest().setAttribute("globalmessage", "该文件可能不属于你");
                return "input";
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            ServletActionContext.getRequest().setAttribute("globalmessage", "未知错误，可能是参数异常");
            return "input";
        }
    }
}
