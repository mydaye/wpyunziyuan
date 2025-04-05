package com.heycolor.yunziyuanbackend.service;


import com.heycolor.yunziyuanbackend.DAOuser.Request.qianDaoParams;
import com.heycolor.yunziyuanbackend.DAOuser.Request.upPswParams;
import com.heycolor.yunziyuanbackend.DAOuser.qianDaoBean;
import com.heycolor.yunziyuanbackend.mapper.userMapper;
import com.heycolor.yunziyuanbackend.DAOuser.userBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
        if (user_login_key !=null && !user_login_key.isEmpty()) {
            return this.usermapper.userLoginKeyTest(user_number, user_login_key);
        }
        return false;
    }

    public void userByReg(String user_number, String user_psw, String user_name,int user_type, String user_tx, int user_state, String user_aihao, int user_points, String user_login_key, Date user_login_time) {
        this.usermapper.userReg(user_number, user_psw, user_name,user_type, user_tx, user_state, user_aihao, user_points, user_login_key, user_login_time);
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

    public int upUserPsw(upPswParams bao) {
        if (bao.getUser_x_psw()!=null && !bao.getUser_x_psw().isEmpty()) {
            return this.usermapper.upUserPsw(bao.getUser_number(), bao.getUser_j_psw(), bao.getUser_x_psw());
        }
        return 0;
    }

    public qianDaoBean getUserQianDao(String user_number) {
        qianDaoBean bean = usermapper.getUserQianDao(user_number);
        if (bean == null) {
            // 获取前天的日期（Java 8+）
            LocalDate twoDaysAgo = LocalDate.now().minusDays(2); //生成前两天的日期
            // 转换为 java.sql.Date（如果数据库需要）
            Date qiandao_time = java.sql.Date.valueOf(twoDaysAgo);
            usermapper.insertQianDao(user_number,0,qiandao_time);
            return usermapper.getUserQianDao(user_number);
        }
        return bean;
    }

    public qianDaoBean upUserQianDao(String user_number) {
        qianDaoBean bean = usermapper.getUserQianDao(user_number);
        Date qiandao_time = new Date();
        if (isYesterday(bean.getQiandao_time())) { //如果是昨天
            usermapper.upUserQianDao(bean.getId(), bean.getUser_number(), bean.getCont_timer() + 1, qiandao_time);
            int points = bean.getCont_timer() + 1;
            if (points > 7) points = 7; //设置积分上限为7
            usermapper.upUserPoints(bean.getUser_number(), points);
        } else if (!isToday(bean.getQiandao_time())){ //如果不是今天也不是昨天,不连续的签到
            usermapper.upUserPoints(bean.getUser_number(),  1);
            usermapper.upUserQianDao(bean.getId(), bean.getUser_number(), 1, qiandao_time);
        }
        return usermapper.getUserQianDao(user_number);
    }
    public int addUserPoints(String user_number, int points) {
        return usermapper.upUserPoints(user_number, points);
    }

    public int getUserPoints(String user_number) {
        return usermapper.getUserPoints(user_number);
    }

    public boolean isYesterday(Date date) {
        if (date == null) {
            return false;
        }
        // 转换为 LocalDate
        LocalDate targetDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        // 获取昨天的日期
        LocalDate yesterday = LocalDate.now().minusDays(1);

        // 比较是否相同
        return yesterday.isEqual(targetDate);
    }

    public boolean isToday(Date date) {
        if (date == null) {
            return false;
        }
        Instant instant = date.toInstant();
        LocalDate targetDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();

        return today.isEqual(targetDate);
    }


}
