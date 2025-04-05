package com.heycolor.yunziyuanbackend.DAOuser.Request;

import java.util.Date;

public class qianDaoParams {
    private final int id;
    private final String user_number;
    private final int cont_timer;
    private final Date qiandao_time;
    private final String user_login_key;

    public qianDaoParams(int id, String userNumber, int contTimer, Date qiandaoTime, String userLoginKey) {
        this.id = id;
        user_number = userNumber;
        cont_timer = contTimer;
        qiandao_time = qiandaoTime;
        user_login_key = userLoginKey;
    }

    public int getId() {
        return id;
    }

    public String getUser_number() {
        return user_number;
    }

    public int getCont_timer() {
        return cont_timer;
    }

    public Date getQiandao_time() {
        return qiandao_time;
    }

    public String getUser_login_key() {
        return user_login_key;
    }
}
