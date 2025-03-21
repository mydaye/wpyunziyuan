package com.heycolor.yunziyuanbackend.DAOuser;

public class userBean {
    private final int id;
    private final String user_number;
    private final String user_psw;
    private final String user_name;
    private final String user_tx;
    private final int user_state;
    private final String user_aihao;
    private final int user_points;
    private final String user_login_key;
    private final String user_login_time;

    public userBean(int id, String user_number, String user_psw, String user_name, String user_tx, int user_state, String user_aihao, int user_points, String userLoginKey, String user_login_time) {
        this.id = id;
        this.user_number = user_number;
        this.user_psw = user_psw;
        this.user_name = user_name;
        this.user_tx = user_tx;
        this.user_state = user_state;
        this.user_aihao = user_aihao;
        this.user_points = user_points;
        this.user_login_key = userLoginKey;
        this.user_login_time = user_login_time;
    }

    public int getId() {
        return id;
    }

    public String getUser_number() {
        return user_number;
    }

    public String getUser_psw() {
        return user_psw;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_tx() {
        return user_tx;
    }

    public int getUser_state() {
        return user_state;
    }

    public String getUser_aihao() {
        return user_aihao;
    }

    public int getUser_points() {
        return user_points;
    }

    public String getUser_login_key() {
        return user_login_key;
    }
    public String getUser_login_time() {
        return user_login_time;
    }
}
