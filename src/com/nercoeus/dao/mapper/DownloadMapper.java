package com.nercoeus.dao.mapper;

import com.nercoeus.action.DownloadLogDeleteAction;
import com.nercoeus.action.Download_log_Action;
import com.nercoeus.action.UploadLogAction;
import com.nercoeus.dao.root.Download_log;
import com.nercoeus.dao.root.Upload;

import java.util.List;

public interface DownloadMapper {

    void insertNum(Upload a) throws Exception;
    List<Download_log> getDownloadLog(Download_log_Action Dlog) throws Exception;
    void deleteByLog(DownloadLogDeleteAction Ds) throws Exception;
    List<Download_log> getUploadLog(UploadLogAction Ulog) throws Exception;
    void deleteUploadByLog(UploadLogAction Ds) throws Exception;
}
