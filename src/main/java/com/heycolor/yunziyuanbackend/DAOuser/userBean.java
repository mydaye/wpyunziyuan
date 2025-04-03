package com.heycolor.yunziyuanbackend.DAOuser;

public class userBean {
    private final Integer id;
    private final String user_number;
    private final String user_psw;
    private final String user_name;
    private final String user_type;
    private final String user_tx;
    private final Integer user_state;
    private final String user_aihao;
    private final Integer user_points;
    private final String user_login_key;
    private final String user_login_time;

    public userBean(Integer id, String user_number, String user_psw, String user_name, String userType, String user_tx, Integer user_state, String user_aihao, Integer user_points, String userLoginKey, String user_login_time) {
        this.id = id;
        this.user_number = user_number;
        this.user_psw = user_psw;
        this.user_name = user_name;
        this.user_type = userType;
        this.user_tx = user_tx;
        this.user_state = user_state;
        this.user_aihao = user_aihao;
        this.user_points = user_points;
        this.user_login_key = userLoginKey;
        this.user_login_time = user_login_time;
    }

    public Integer getId() {
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

    public String getUser_type() {
        return user_type;
    }

    public String getUser_tx() {
        return user_tx;
    }

    public Integer getUser_state() {
        return user_state;
    }

    public String getUser_aihao() {
        return user_aihao;
    }

    public Integer getUser_points() {
        return user_points;
    }

    public String getUser_login_key() {
        return user_login_key;
    }
    public String getUser_login_time() {
        return user_login_time;
    }
}
