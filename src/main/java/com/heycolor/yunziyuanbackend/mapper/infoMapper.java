package com.heycolor.yunziyuanbackend.mapper;

import com.heycolor.yunziyuanbackend.DAOinfo.Request.addParams;
import com.heycolor.yunziyuanbackend.DAOinfo.addBean;
import com.heycolor.yunziyuanbackend.DAOinfo.infoBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface infoMapper {
    List<infoBean> selectInfo();
    int infoAdd(addBean bean);
}
