//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.dao;

import com.nercoeus.action.SearchFileAction;
import com.nercoeus.dao.mapper.FileMapper;
import com.nercoeus.dao.root.File;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class FileDao {
    public FileDao() {
    }

    public List<File> getAllFiles(SearchFileAction searchFileAction) throws Exception {
        SqlSession session = DaoUtil.getSqlSession();
        FileMapper mapper = (FileMapper)session.getMapper(FileMapper.class);
        List<File> allFiles = mapper.getAllFiles(searchFileAction);
        session.close();
        return allFiles;
    }

    public String findFilepathById(int id) throws Exception {
        SqlSession session = DaoUtil.getSqlSession();
        FileMapper mapper = (FileMapper)session.getMapper(FileMapper.class);
        String filepath = mapper.findFilepathById(id);
        session.close();
        return filepath;
    }
}
