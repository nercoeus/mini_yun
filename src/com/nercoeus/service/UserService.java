//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.service;

import com.nercoeus.dao.mapper.UserMapper;
import com.nercoeus.dao.root.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    @Autowired
    private UserMapper dao;

    public UserService() {
    }

    public void createUser(User user) throws Exception {
        Boolean found = this.findUser(user.getUsername());
        if (!found) {
            this.dao.createUser(user);
        } else {
            throw new RuntimeException();
        }
    }

    public String checkUser(User user) throws Exception {
        return this.dao.checkUser(user);
    }

    public boolean findUser(String username) throws Exception {
        Integer found = this.dao.findUser(username);
        return found != null && found >= 1;
    }

    public int isVip(String user_name) throws Exception {
        return this.dao.isVip(user_name);
    }
}
