//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.action;

import com.nercoeus.dao.root.User;
import com.nercoeus.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import org.apache.struts2.ServletActionContext;

public class LogupAction extends ActionSupport {
    private String username;
    private String password;
    boolean flag = true;
    UserService userService;
    User user;

    public LogupAction() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public String execute() {
        return "success";
    }

    public void validateLogup() {
        char[] u = this.username.toCharArray();
        char[] p = this.password.toCharArray();

        int i;
        for(i = 0; i < u.length; ++i) {
            if (!Character.isDigit(u[i]) && !Character.isLetter(u[i])) {
                this.flag = false;
            }
        }

        for(i = 0; i < p.length; ++i) {
            if (!Character.isDigit(p[i]) && !Character.isLetter(p[i])) {
                this.flag = false;
            }
        }

        if (!this.flag) {
            ServletActionContext.getRequest().setAttribute("usernameerror", "用户名由数字和字符组成");
            ServletActionContext.getRequest().setAttribute("passworderror", "密码由数字和字符组成");
            this.addFieldError("", "");
        } else if (this.username.length() <= 20 && this.username.length() >= 6) {
            if (this.password.length() > 20 || this.password.length() < 6) {
                ServletActionContext.getRequest().setAttribute("passworderror", "密码必须6-20位");
                this.addFieldError("", "");
            }
        } else {
            ServletActionContext.getRequest().setAttribute("usernameerror", "用户名必须6-20位");
            this.addFieldError("", "");
        }

    }

    public String logup() {
        this.user.setPassword(this.password);
        this.user.setUsername(this.username);
        if (!this.flag) {
            return "input";
        } else {
            try {
                this.userService.createUser(this.user);
                String path = File.separator + "home" + File.separator + "nercoeus" + File.separator + "Desktop" + File.separator + "upload";
                File file = new File(path + File.separator + this.username);
                file.mkdir();
                return "success";
            } catch (Exception var3) {
                var3.printStackTrace();
                ServletActionContext.getRequest().setAttribute("usernameerror", "该用户已经注册");
                return "error";
            }
        }
    }
}
