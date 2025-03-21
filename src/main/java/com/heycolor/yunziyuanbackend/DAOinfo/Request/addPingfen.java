package com.heycolor.yunziyuanbackend.DAOinfo.Request;

public class addPingfen {
    private final int id;
    private final String user_number;
    private final String user_login_key;
    private final String type;
    private final int data_id;
    private final int count_score;

    public addPingfen(int id, String user_number, String user_login_key, String type, int dataId, int count_score) {
        this.id = id;
        this.user_number = user_number;
        this.user_login_key = user_login_key;
        this.type = type;
        this.data_id = dataId;
        this.count_score = count_score;
    }

    public int getId() {
        return id;
    }

    public String getUser_number() {
        return user_number;
    }

    public String getType() {
        return type;
    }

    public String getUser_login_key() {
        return user_login_key;
    }

    public int getData_id() {
        return data_id;
    }

    public int getCount_score() {
        return count_score;
    }
}
