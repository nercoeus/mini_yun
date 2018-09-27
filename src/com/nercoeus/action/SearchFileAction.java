//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.action;

import com.nercoeus.dao.root.PageBean;
import com.nercoeus.service.FileService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.apache.struts2.ServletActionContext;

public class SearchFileAction extends ActionSupport {
    private String searchcontent;
    private int currentpage = 1;
    private int pagesize = 10;
    private int startindex;
    private PageBean pageBean;
    private FileService service;

    public SearchFileAction() {
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public void setService(FileService service) {
        this.service = service;
    }

    public String getSearchcontent() {
        return this.searchcontent;
    }

    public void setSearchcontent(String t) {
        this.searchcontent = t;
    }

    public int getCurrentpage() {
        return this.currentpage;
    }

    public void setCurrentpage(int c) {
        if (c <= 0) {
            this.currentpage = 1;
        } else {
            this.currentpage = c;
        }

    }

    public int getPagesize() {
        return this.pagesize;
    }

    public void setPagesize(int pagesize) {
        if (pagesize <= 0) {
            this.pagesize = 5;
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

    public String listFiles() throws Exception {
        return this.execute();
    }

    public String execute() throws Exception {
        if ("".equals(this.searchcontent)) {
            ServletActionContext.getRequest().setAttribute("messages", "请输入要查找的文件名！");
            return "nofile";
        } else if ("".equals(this.searchcontent)) {
            ServletActionContext.getRequest().setAttribute("messages", "请输入要查找的文件名！");
            return "nofile";
        } else {
            List list;
            try {
                list = this.service.getAllFiles(this);
                if (list.size() == 0) {
                    ServletActionContext.getRequest().setAttribute("messages", "没有找到想要的文件！");
                    return "nofile";
                }
            } catch (Exception var3) {
                var3.printStackTrace();
                return "input";
            }

            this.pageBean.setList(list);
            this.pageBean.setCurrentpage(this.currentpage);
            this.pageBean.setPagesize(this.pagesize);
            this.pageBean.setTotalrecord(this.service.countShareFiles(this));
            ServletActionContext.getRequest().setAttribute("pagebean", this.pageBean);
            ServletActionContext.getRequest().setAttribute("searchcontent", this.searchcontent);
            return "success";
        }
    }
}
