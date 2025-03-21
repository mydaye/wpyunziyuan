package com.heycolor.yunziyuanbackend.DAOuser.Request;

public class upInfoParams {
    private final String user_number;
    private final String user_login_key;
    private final String type;
    private final String value;

    public upInfoParams(String userNumber, String userLoginKey, String type, String value) {
        this.user_number = userNumber;
        this.user_login_key = userLoginKey;
        this.type = type;
        this.value = value;
    }

    public String getUser_number() {
        return user_number;
    }

    public String getUser_login_key() {
        return user_login_key;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
