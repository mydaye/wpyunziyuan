package com.heycolor.yunziyuanbackend.DAOManage;

import lombok.Data;

@Data
public class ManageVO {
    private int operateId;

    private int id;

    private String user_number;

    private String user_psw;

    private String user_type;

    private String operate;

    private int pageSize;

    private int pageIndex;

    private int dataId;
}
