package com.nercoeus.dao.root;
import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("upload")
@Scope("prototype")
public class Upload {

    private String user_name;
    private String file_name;
    private Date upload_time;

    public Upload() {
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }

    public Date getUpload_time() {
        return upload_time;
    }

}

