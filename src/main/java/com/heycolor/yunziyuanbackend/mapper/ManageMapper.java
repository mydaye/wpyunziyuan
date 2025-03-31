package com.heycolor.yunziyuanbackend.mapper;

import com.heycolor.yunziyuanbackend.DAOManage.ManageVO;
import com.heycolor.yunziyuanbackend.DAOManage.ManagerRe;
import com.heycolor.yunziyuanbackend.DAOManage.ResourceRe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManageMapper {
    List<ManagerRe> getManagerReList(ManageVO vo);

    int deleteManager(ManageVO vo);

    List<ResourceRe> getResourceeList(ManageVO vo);

    int addResource(ManageVO vo);

    int deleteResource(ManageVO vo);

    int updateResource(ManageVO vo);
}
