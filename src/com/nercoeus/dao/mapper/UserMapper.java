//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.dao.mapper;

import com.nercoeus.dao.root.User;

public interface UserMapper {
    void createUser(User var1) throws Exception;

    String checkUser(User var1) throws Exception;

    Integer findUser(String var1) throws Exception;

    Integer isVip(String var1) throws Exception;
}
