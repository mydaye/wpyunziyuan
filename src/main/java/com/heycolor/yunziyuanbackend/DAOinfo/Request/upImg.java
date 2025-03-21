package com.heycolor.yunziyuanbackend.DAOinfo.Request;

import org.springframework.web.multipart.MultipartFile;

public class upImg {
    private final String user_number;
    private final String user_login_key;
    private final MultipartFile file;

    public upImg(String userNumber, String userLoginKey, MultipartFile file) {
        user_number = userNumber;
        user_login_key = userLoginKey;
        this.file = file;
    }

    public String getUser_number() {
        return user_number;
    }

    public String getUser_login_key() {
        return user_login_key;
    }

    public MultipartFile getFile() {
        return file;
    }
}
