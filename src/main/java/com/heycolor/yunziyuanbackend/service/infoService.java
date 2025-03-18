package com.heycolor.yunziyuanbackend.service;


import com.heycolor.yunziyuanbackend.DAOinfo.Request.addParams;
import com.heycolor.yunziyuanbackend.DAOinfo.addBean;
import com.heycolor.yunziyuanbackend.DAOinfo.infoBean;
import com.heycolor.yunziyuanbackend.mapper.infoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class infoService {
    private final infoMapper infomapper;

    @Autowired
    public infoService(infoMapper infomapper) {
        this.infomapper = infomapper;
    }

    public List<infoBean> selectInfo() {
        return this.infomapper.selectInfo();
    }

    public int infoAdd(addBean info) {
        return this.infomapper.infoAdd(info);
    }

}
