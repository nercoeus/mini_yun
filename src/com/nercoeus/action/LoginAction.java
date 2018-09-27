//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.action;

import com.nercoeus.dao.root.File;
import com.nercoeus.dao.root.User;
import com.nercoeus.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;
    private UserService userService;
    private User user;

    public LoginAction() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setService(UserService service) {
        this.userService = service;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() {
        return "success";
    }

    public void validateLogin() {
        char[] u = this.username.toCharArray();
        char[] p = this.password.toCharArray();
        boolean flag = true;

        int i;
        for(i = 0; i < u.length; ++i) {
            if (!Character.isDigit(u[i]) && !Character.isLetter(u[i])) {
                flag = false;
            }
        }

        for(i = 0; i < p.length; ++i) {
            if (!Character.isDigit(p[i]) && !Character.isLetter(p[i])) {
                flag = false;
            }
        }

        if (!flag) {
            ServletActionContext.getRequest().setAttribute("error", "请输入正确的用户名和密码!");
            this.addFieldError("", "");
        }

    }

    public String login() {
        this.user.setUsername(this.username);
        this.user.setPassword(this.password);

        try {
            String user_name = this.userService.checkUser(this.user);
            if (user_name != null && !"".equals(user_name)) {
                ActionContext.getContext().getSession().put("user_name", user_name);
                return "success";
            } else {
                ServletActionContext.getRequest().setAttribute("error", "用户名密码错误!");
                return "input";
            }
        } catch (Exception var2) {
            var2.printStackTrace();
            return "error";
        }
    }
}
