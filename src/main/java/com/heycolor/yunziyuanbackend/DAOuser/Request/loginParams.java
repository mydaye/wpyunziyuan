package com.heycolor.yunziyuanbackend.DAOuser.Request;

public class loginParams {
    private final String user_number;
    private final String user_psw;

    private final String user_type;

    public loginParams(String user_number, String user_psw, String user_type) {
        this.user_number = user_number;
        this.user_psw = user_psw;
        this.user_type = user_type;
    }

    public String getUser_number() {
        return user_number;
    }

    public String getUser_psw() {
        return user_psw;
    }

    public String getUser_type() {
        return user_type;
    }
}
