//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.dao;

import com.nercoeus.dao.mapper.UserMapper;
import com.nercoeus.dao.root.User;
import org.apache.ibatis.session.SqlSession;

public class UserDao {
    public UserDao() {
    }

    public void createUser(User user) throws Exception {
        SqlSession session = DaoUtil.getSqlSession();
        UserMapper mapper = (UserMapper)session.getMapper(UserMapper.class);
        mapper.createUser(user);
        session.commit();
        session.close();
    }

    public String checkUser(User user) throws Exception {
        SqlSession session = DaoUtil.getSqlSession();
        UserMapper mapper = (UserMapper)session.getMapper(UserMapper.class);
        String user_name = mapper.checkUser(user);
        session.close();
        return user_name;
    }

    public boolean findUser(String username) throws Exception {
        SqlSession session = DaoUtil.getSqlSession();
        UserMapper mapper = (UserMapper)session.getMapper(UserMapper.class);
        Integer found = mapper.findUser(username);
        session.close();
        return found != null && found >= 1;
    }

    public int isVip(String user_name) throws Exception {
        SqlSession session = DaoUtil.getSqlSession();
        UserMapper mapper = (UserMapper)session.getMapper(UserMapper.class);
        Integer isvip = mapper.isVip(user_name);
        session.close();
        return isvip != null && isvip != 0 ? 1 : 0;
    }
}
