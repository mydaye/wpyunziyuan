package com.heycolor.yunziyuanbackend.DAOuser.Request;

public class upPswParams {
    private final String user_number;
    private final String user_login_key;
    private final String user_j_psw;
    private final String user_x_psw;

    public upPswParams(String user_number, String userLoginKey, String user_j_psw, String user_x_psw) {
        this.user_number = user_number;
        this.user_login_key = userLoginKey;
        this.user_j_psw = user_j_psw;
        this.user_x_psw = user_x_psw;
    }

    public String getUser_number() {
        return user_number;
    }

    public String getUser_login_key() {
        return user_login_key;
    }

    public String getUser_j_psw() {
        return user_j_psw;
    }

    public String getUser_x_psw() {
        return user_x_psw;
    }
}
