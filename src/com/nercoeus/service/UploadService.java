package com.nercoeus.service;

import com.nercoeus.dao.mapper.UploadMapper;
import com.nercoeus.dao.root.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("uploadService")
public class UploadService {

    @Autowired
    private UploadMapper dao;

    public UploadService() {
    }

    public void insertNum(Upload u) throws Exception {
        this.dao.insertNum(u);
    }
}
