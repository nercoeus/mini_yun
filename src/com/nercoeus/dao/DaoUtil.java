//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.dao;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DaoUtil {
    private static SqlSessionFactory sqlSessionFactory;

    public DaoUtil() {
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    static {
        String resource = "SqlMapConfig.xml";

        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException(var3);
        }

        sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
    }
}
