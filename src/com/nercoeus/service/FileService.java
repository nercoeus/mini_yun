//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.service;

import com.nercoeus.action.ChangefilesshareAction;
import com.nercoeus.action.SearchFileAction;
import com.nercoeus.action.SearchUserFilesAction;
import com.nercoeus.dao.mapper.FileMapper;
import com.nercoeus.dao.root.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fileService")
public class FileService {
    @Autowired
    private FileMapper dao;

    public FileService() {
    }

    public List<File> getAllFiles(SearchFileAction s) throws Exception {
        return this.dao.getAllFiles(s);
    }

    public int countShareFiles(SearchFileAction searchFileAction) throws Exception {
        return this.dao.count(searchFileAction);
    }

    public String findFilepathById(int id) throws Exception {
        return this.dao.findFilepathById(id);
    }

    public String findFilenameById(int id) throws Exception {
        return this.dao.findFilenameById(id);
    }

    public List<File> getUserFiles(SearchUserFilesAction s) throws Exception {
        return this.dao.getUserFiles(s);
    }

    public int countUserFiles(SearchUserFilesAction s) throws Exception {
        return this.dao.countUserFiles(s);
    }

    public Integer insertFile(File file) throws Exception {
        return this.dao.insertFile(file);
    }

    public void deleteFileById(int id) throws Exception {
        this.dao.deleteFileById(id);
    }

    public void changeShareById(ChangefilesshareAction a) throws Exception {
        this.dao.changeShareById(a);
    }
}
