package com.heycolor.yunziyuanbackend.DAOManage;

import lombok.Data;

import java.util.Date;

@Data
public class ManagerRe {
    private Integer id;
    private Long user_number;
    private String user_psw;
    private String user_name;
    private Integer user_type;
    private String user_tx;
    private Integer user_state;
    private String user_aihao;
    private Integer user_points;
    private String user_login_key;
    private Date user_login_time;
}
