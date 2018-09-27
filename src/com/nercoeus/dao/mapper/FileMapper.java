//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.dao.mapper;

import com.nercoeus.action.ChangefilesshareAction;
import com.nercoeus.action.SearchFileAction;
import com.nercoeus.action.SearchUserFilesAction;
import com.nercoeus.dao.root.File;
import java.util.List;

public interface FileMapper {
    List<File> getAllFiles(SearchFileAction var1) throws Exception;

    int count(SearchFileAction var1) throws Exception;

    String findFilenameById(int var1) throws Exception;

    String findFilepathById(int var1) throws Exception;

    Integer insertFile(File var1) throws Exception;

    List<File> getUserFiles(SearchUserFilesAction var1) throws Exception;

    void deleteFileById(int var1);

    int countUserFiles(SearchUserFilesAction var1) throws Exception;

    void changeShareById(ChangefilesshareAction var1) throws Exception;
}
