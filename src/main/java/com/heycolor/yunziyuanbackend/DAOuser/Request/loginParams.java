package com.heycolor.yunziyuanbackend.DAOuser.Request;

public class loginParams {
    private final String user_number;
    private final String user_psw;

    public loginParams(String user_number, String user_psw) {
        this.user_number = user_number;
        this.user_psw = user_psw;
    }

    public String getUser_number() {
        return user_number;
    }

    public String getUser_psw() {
        return user_psw;
    }
}
