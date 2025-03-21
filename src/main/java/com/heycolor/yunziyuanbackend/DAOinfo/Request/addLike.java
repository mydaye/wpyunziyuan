package com.heycolor.yunziyuanbackend.DAOinfo.Request;

public class addLike {
    private final int id;
    private final String user_number;
    private final String user_login_key;
    private final String type;
    private final int data_id;

    public addLike(int id, String user_number, String user_login_key, String type, int data_id) {
        this.id = id;
        this.user_number = user_number;
        this.user_login_key = user_login_key;
        this.type = type;
        this.data_id = data_id;
    }

    public int getId() {
        return id;
    }

    public String getUser_login_key() {
        return user_login_key;
    }

    public String getType() {
        return type;
    }

    public String getUser_number() {
        return user_number;
    }

    public int getData_id() {
        return data_id;
    }
}
