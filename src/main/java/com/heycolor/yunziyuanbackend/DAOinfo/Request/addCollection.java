package com.heycolor.yunziyuanbackend.DAOinfo.Request;


//收藏
public class addCollection {
    private final int id;
    private final String user_number;
    private final String user_login_key;
    private final String type;
    private final int data_id;
    private final String data_title;
    private final String data_img_list;

    public addCollection(int id, String userNumber, String userLoginKey, String type, int dataId, String dataTitle, String dataImgList) {
        this.id = id;
        user_number = userNumber;
        user_login_key = userLoginKey;
        this.type = type;
        data_id = dataId;
        data_title = dataTitle;
        data_img_list = dataImgList;
    }

    public int getId() {
        return id;
    }

    public String getUser_number() {
        return user_number;
    }

    public String getUser_login_key() {
        return user_login_key;
    }

    public String getType() {
        return type;
    }

    public int getData_id() {
        return data_id;
    }

    public String getData_title() {
        return data_title;
    }

    public String getData_img_list() {
        return data_img_list;
    }
}
