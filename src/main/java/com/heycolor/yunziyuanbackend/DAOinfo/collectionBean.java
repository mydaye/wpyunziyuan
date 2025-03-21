package com.heycolor.yunziyuanbackend.DAOinfo;



//收藏
public class collectionBean {
    private final int id;
    private final String user_number;
    private final int data_id;
    private final String data_title;
    private final String data_img_list;

    public collectionBean(int id, String user_number, int data_id, String data_title, String data_img_list) {
        this.id = id;
        this.user_number = user_number;
        this.data_id = data_id;
        this.data_title = data_title;
        this.data_img_list = data_img_list;
    }

    public int getId() {
        return id;
    }

    public String getUser_number() {
        return user_number;
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
