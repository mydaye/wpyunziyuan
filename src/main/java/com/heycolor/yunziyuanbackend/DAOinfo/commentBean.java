package com.heycolor.yunziyuanbackend.DAOinfo;

import java.util.Date;


//评论
public class commentBean {
    private final int id;
    private final String user_number;
    private final int data_id;
    private final String comment;
    private final Date create_time;

    public commentBean(int id, String user_number, int data_id, String comment, Date create_time) {
        this.id = id;
        this.user_number = user_number;
        this.data_id = data_id;
        this.comment = comment;
        this.create_time = create_time;
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

    public String getComment() {
        return comment;
    }

    public Date getCreate_time() {
        return create_time;
    }
}
