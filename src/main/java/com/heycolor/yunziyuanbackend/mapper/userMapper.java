package com.heycolor.yunziyuanbackend.mapper;


import com.heycolor.yunziyuanbackend.DAOuser.qianDaoBean;
import com.heycolor.yunziyuanbackend.DAOuser.userBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface userMapper {
    List<userBean> selectUser();
    userBean userLogin(String user_number, String user_psw);
    boolean userTest(String user_number);
    void userReg(String user_number, String user_psw,String user_name, int user_type, String user_tx, int user_state, String user_aihao,int user_points,String user_login_key, Date user_login_time);
    void upLongDate(int id, String user_login_key, Date user_login_time);

    int upUserInfo(String user_number, String user_psw, String user_name, String user_tx, String user_aihao);
    boolean userLoginKeyTest(String user_number, String user_login_key);

    int upUserPsw(String user_number, String user_j_psw, String user_x_psw);

    qianDaoBean getUserQianDao(String user_number);

    void insertQianDao(String user_number, int cont_timer, Date qiandao_time);

    void upUserQianDao(int id, String user_number, int cont_timer, Date qiandao_time);
    int upUserPoints(String user_number, int user_points);
    int getUserPoints(String user_number);

}