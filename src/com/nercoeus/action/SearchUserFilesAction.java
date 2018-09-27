//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.action;

import com.nercoeus.dao.root.PageBean;
import com.nercoeus.service.FileService;
import com.nercoeus.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.apache.struts2.ServletActionContext;

public class SearchUserFilesAction extends ActionSupport {
    private int currentpage = 1;
    private int pagesize = 10;
    private int startindex;
    private String filepath;
    private PageBean pageBean;
    private FileService fileService;
    private UserService userService;

    public SearchUserFilesAction() {
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public int getCurrentpage() {
        return this.currentpage;
    }

    public void setCurrentpage(int currentpage) {
        if (currentpage <= 0) {
            this.currentpage = 1;
        } else {
            this.currentpage = currentpage;
        }

    }

    public int getPagesize() {
        return this.pagesize;
    }

    public void setPagesize(int pagesize) {
        if (pagesize <= 0) {
            this.pagesize = 10;
        } else {
            this.pagesize = pagesize;
        }

    }

    public int getStartindex() {
        this.startindex = (this.currentpage - 1) * this.pagesize;
        return this.startindex;
    }

    public void setStartindex(int startindex) {
        this.startindex = startindex;
    }

    public String execute() throws Exception {
        List list;
        try {
            String username = (String)ActionContext.getContext().getSession().get("user_name");
            if (username == null || "".equals(username)) {
                return "input";
            }

            this.filepath = username;
            list = this.fileService.getUserFiles(this);
        } catch (Exception var3) {
            var3.printStackTrace();
            return "input";
        }

        Integer vip = (Integer)ServletActionContext.getRequest().getAttribute("isvip");
        if (vip == null) {
            vip = this.userService.isVip(this.filepath);
            ServletActionContext.getRequest().setAttribute("isvip", vip);
        }

        this.pageBean.setList(list);
        this.pageBean.setPagesize(this.pagesize);
        this.pageBean.setTotalrecord(this.fileService.countUserFiles(this));
        this.pageBean.setCurrentpage(this.currentpage);
        ServletActionContext.getRequest().setAttribute("pagebean", this.pageBean);
        return "success";
    }
}
