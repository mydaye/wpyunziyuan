package com.heycolor.yunziyuanbackend.DAOuser.Request;

public class getParams {
    private final Integer data_id;
    private final String user_number;
    private final String user_login_key;


    public getParams(Integer dataId, String userNumber, String userLoginKey) {
        data_id = dataId;

        user_number = userNumber;
        user_login_key = userLoginKey;
    }

    public Integer getData_id() {
        return data_id;
    }

    public String getUser_number() {
        return user_number;
    }

    public String getUser_login_key() {
        return user_login_key;
    }
}
