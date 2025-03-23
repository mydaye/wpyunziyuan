package com.heycolor.yunziyuanbackend.mapper;

import com.heycolor.yunziyuanbackend.DAOinfo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface infoMapper {
    List<infoBean> selectInfo();
    int infoAdd(addBean bean);

    //用户点赞操作
    int infoLikeAdd(String user_number,int data_id);
    int infoLikeCount(int data_id);
    int infoLikeDel(String user_number,int data_id);
    boolean infoLikeGet(String user_number,int data_id);

    //用户评价和获取

    int infoPingfenDataAdd(int data_id, int count_score);
    int infoPingfenAdd(String user_number,int data_id,int count_score);
    List<pingfenBean> infoPingfenGet(String user_number, int data_id);

    //用户收藏
    int infoCollectionAdd(String user_number,int data_id,String data_title,String data_img_list);
    //用户收藏删除
    int infoCollectionDel(String user_number,int data_id);
    boolean infoCollectionGet(String user_number,int data_id);
    List<collectionBean> infoCollectionGetAll(String user_number);

    //用户评论增加
    int infoCommentAdd(String user_number, String user_tx, int data_id, String comment, Date create_time);
    //用户评论删除
    int infoCommentDel(int id,String user_number);
    List<commentBean> infoCommentGetAll(int data_id);


}
