package com.heycolor.yunziyuanbackend.service;


import com.heycolor.yunziyuanbackend.DAOinfo.*;
import com.heycolor.yunziyuanbackend.DAOinfo.Request.*;
import com.heycolor.yunziyuanbackend.mapper.infoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<infoBean> selectInfoTrue() {
        List<infoBean> infoBeans = infomapper.selectInfoTrue();
        List<Integer> dataIdList = infoBeans.stream().map(infoBean::getId).collect(Collectors.toList());
        Map<Integer,Integer> dataLikeMap = infomapper.selectUserLikeByDataIds(dataIdList);
        Map<Integer,Integer> dataCommentMap = infomapper.selectUserCommentCountByDataIds(dataIdList);
        if(!CollectionUtils.isEmpty(infoBeans))
            infoBeans.forEach(e->{
                if(!CollectionUtils.isEmpty(dataLikeMap))
                    e.setDataCommentCount(dataCommentMap.getOrDefault(e.getId(),0));
                if(!CollectionUtils.isEmpty(dataLikeMap))
                    e.setDataLikeCount(dataLikeMap.getOrDefault(e.getId(),0));
            });
        return infoBeans;
    }

    public int infoAdd(addBean info) {
        return this.infomapper.infoAdd(info);
    }

    public int infoLikeAdd(addLike bao) {
       return this.infomapper.infoLikeAdd(bao.getUser_number(),bao.getData_id());
    }
    public int infoLikeCount(addLike bao) {
        return this.infomapper.infoLikeCount(bao.getData_id());
    }
    public int infoLikeDel(addLike bao) {
        return this.infomapper.infoLikeDel(bao.getUser_number(),bao.getData_id());
    }
    public boolean infoLikeGet(addLike bao) {
        return this.infomapper.infoLikeGet(bao.getUser_number(),bao.getData_id());
    }

    public int infoPingfenAdd(addPingfen bao) {
        int a =  this.infomapper.infoPingfenAdd(bao.getUser_number(),bao.getData_id(),bao.getCount_score());
        if (a > 0) {
            return this.infomapper.infoPingfenDataAdd(bao.getData_id(),bao.getCount_score());
        }
        return 0;
    }

    public List<pingfenBean> infoPingfenGet(addPingfen bao) {
        return this.infomapper.infoPingfenGet(bao.getUser_number(),bao.getData_id());
    }

    public int infoCollectionAdd(addCollection bao) {
        // 收藏时间
        Date create_time = new Date();
        return this.infomapper.infoCollectionAdd(bao.getUser_number(),bao.getData_id(),bao.getData_title(),bao.getData_img_list(),create_time);
    }
    public int infoCollectionDel(addCollection bao) {
        return this.infomapper.infoCollectionDel(bao.getUser_number(),bao.getData_id());
    }
    public boolean infoCollectionGet(addCollection bao) {
        return this.infomapper.infoCollectionGet(bao.getUser_number(),bao.getData_id());
    }
    //查找指定用户的所有收藏
    public List<collectionBean> infoCollectionGetAll(String user_number) {
        return this.infomapper.infoCollectionGetAll(user_number);
    }

    //用户评论 增加
    public int infoCommentAdd(addComment bao) {
        // 评论时间
        Date create_time = new Date();
        return this.infomapper.infoCommentAdd(bao.getUser_number(), bao.getUser_name(), bao.getUser_tx(), bao.getData_id(), bao.getComment(), create_time);
    }

    public int infoCommentDel(addComment bao) {
        return this.infomapper.infoCommentDel(bao.getId(),bao.getUser_number());
    }
    //查找指定data的所有评价
    public List<commentBean> infoCommentGetAll(int data_id) {
        return this.infomapper.infoCommentGetAll(data_id);
    }
}
