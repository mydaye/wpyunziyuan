package com.heycolor.yunziyuanbackend.DAOuser;

import java.util.Date;

public class qianDaoBean {
    private final int id;
    private final String user_number;
    private final int cont_timer;
    private final Date qiandao_time;

    public qianDaoBean(int id, String userNumber, int contTimer, Date qiandaoTime) {
        this.id = id;
        user_number = userNumber;
        cont_timer = contTimer;
        qiandao_time = qiandaoTime;
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
}
