package com.heycolor.yunziyuanbackend.service;


import com.heycolor.yunziyuanbackend.mapper.userMapper;
import com.heycolor.yunziyuanbackend.DAOuser.userBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class userService {
    private final userMapper usermapper;

    @Autowired
    public userService(userMapper usermapper) {
        this.usermapper = usermapper;
    }

    //检测用户是否存在
    public boolean userByTest(String user_number) {
        return this.usermapper.userTest(user_number);
    }

    //用户登陆检测
    public boolean userByLoginTest(String user_number, String user_login_key) {
        return this.usermapper.userLoginKeyTest(user_number, user_login_key);
    }

    public void userByReg(String user_number, String user_psw, String user_name, String user_tx, int user_state, String user_aihao, int user_points, String user_login_key, Date user_login_time) {
        this.usermapper.userReg(user_number, user_psw, user_name, user_tx, user_state, user_aihao, user_points, user_login_key, user_login_time);
    }
    public userBean userByLogin(String user_number, String user_psw) {
        return this.usermapper.userLogin(user_number, user_psw);
    }

    //更新用户登陆时间
    public void upLoginTimer(int id, String user_login_key, Date user_login_time) {
        this.usermapper.upLongDate(id, user_login_key, user_login_time);
    }

    //更新用户信息
    public int upUserInfo(String user_number, String user_psw, String user_name, String user_tx, String user_aihao) {
       return this.usermapper.upUserInfo(user_number, user_psw, user_name, user_tx, user_aihao);
    }
}
