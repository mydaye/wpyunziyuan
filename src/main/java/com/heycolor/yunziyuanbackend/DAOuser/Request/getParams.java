package com.heycolor.yunziyuanbackend.DAOuser.Request;

public class getParams {
    private final String user_number;
    private final String user_login_key;


    public getParams(String userNumber, String userLoginKey) {
        user_number = userNumber;
        user_login_key = userLoginKey;
    }
}
