package com.heycolor.yunziyuanbackend.DAOinfo;

public class pingfenBean {
    private final int id;
    private final String user_number;
    private final int data_id;
    private final int count_score;

    public pingfenBean(int id, String user_number, int data_id, int count_score) {
        this.id = id;
        this.user_number = user_number;
        this.data_id = data_id;
        this.count_score = count_score;
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

    public int getCount_score() {
        return count_score;
    }
}
