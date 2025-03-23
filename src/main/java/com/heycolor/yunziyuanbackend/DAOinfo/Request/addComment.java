package com.heycolor.yunziyuanbackend.DAOinfo.Request;

//评论
public class addComment {
    private final int id;
    private final String user_number;
    private final String user_tx;
    private final String user_login_key;
    private final String type;
    private final int data_id;
    private final String comment;

    public addComment(int id, String user_number, String userTx, String user_login_key, String type, int data_id, String comment) {
        this.id = id;
        this.user_number = user_number;
        this.user_tx = userTx;
        this.user_login_key = user_login_key;
        this.type = type;
        this.data_id = data_id;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getUser_number() {
        return user_number;
    }

    public String getUser_tx() {
        return user_tx;
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

    public String getComment() {
        return comment;
    }
}
