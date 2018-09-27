package com.nercoeus.service;

import com.nercoeus.action.DownloadLogDeleteAction;
import com.nercoeus.action.Download_log_Action;
import com.nercoeus.action.UploadLogAction;
import com.nercoeus.dao.mapper.DownloadMapper;
import com.nercoeus.dao.mapper.UploadMapper;
import com.nercoeus.dao.root.Download_log;
import com.nercoeus.dao.root.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("downloadService")
public class DownloadService {

    @Autowired
    private DownloadMapper dao;

    public DownloadService() {
    }

    public void insertNum(Upload u) throws Exception {
        this.dao.insertNum(u);
    }
    public List<Download_log> getDownloadLog(Download_log_Action Ds) throws Exception{
        return dao.getDownloadLog(Ds);
    }
    public List<Download_log> getUploadLog(UploadLogAction Us) throws Exception{
        return dao.getUploadLog(Us);
    }
    public void deleteByLog(DownloadLogDeleteAction Ds) throws Exception{
        this.dao.deleteByLog(Ds);
    }
    public void deleteUploadByLog(UploadLogAction Us) throws Exception{
        this.dao.deleteUploadByLog(Us);
    }

}