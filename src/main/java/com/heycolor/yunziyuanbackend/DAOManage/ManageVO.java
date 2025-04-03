package com.heycolor.yunziyuanbackend.DAOManage;

import lombok.Data;

import java.util.Date;

@Data
public class ManageVO {
    private int operateId;

    private int id;

    private String user_number;

    private String user_psw;

    private String user_type;

    private String user_state;

    private String operate;

    private int pageSize;

    private int pageIndex;

    private String searchField;

    private String searchValue;

    private int dataId;

    private int userSate;

    private String dataTitle;
    private int dataState;
    private String dataImgList;
    private String dataImgMx;
    private String dataUrl;
    private int dataGood;
    private String dataDir;
    private String dataType;
    private String dataCountry;
    private String dataYear;
    private String dataNote;
    private int countPeople;
    private int countScore;
    private Date gmtCreate;
}
