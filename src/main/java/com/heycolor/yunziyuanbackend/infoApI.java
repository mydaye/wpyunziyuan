package com.heycolor.yunziyuanbackend;

import com.heycolor.yunziyuanbackend.DAOinfo.*;
import com.heycolor.yunziyuanbackend.DAOinfo.Request.*;
import com.heycolor.yunziyuanbackend.constant.ReturnInfo;
import com.heycolor.yunziyuanbackend.service.infoService;
import com.heycolor.yunziyuanbackend.service.userService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.heycolor.yunziyuanbackend.constant.StateCode.*;

@RequestMapping("/info")
@RestController
public class infoApI {
    private final infoService xInfo;
    private final userService xUser;
    public infoApI(infoService xInfo, userService xUser) {
        this.xInfo = xInfo;
        this.xUser = xUser;
    }

    //返回所有数据
    @GetMapping({"/getData/all"})
    private ResponseEntity<ReturnInfo> userGetData() {
        List<infoBean> dbData = xInfo.selectInfo();
        if (!dbData.isEmpty()) {
            return ResponseEntity.ok()
                    .body(ReturnInfo.res(SUCCESS, "", dbData));
        }
        return ResponseEntity.ok()
                .body(ReturnInfo.res(NOT_LOGGED_IN, "", dbData));

    }
    //用户点赞操作
    @PostMapping({"/user/like/addDelGet"})
    private ResponseEntity<ReturnInfo> userLikeAdd(@Validated @RequestBody addLike bao) {
        boolean uTest = xUser.userByLoginTest(bao.getUser_number(),bao.getUser_login_key());
        if (!uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(KEY_ERROR, "请重新登陆", null));
        }
        int dbData=0;
        switch (bao.getType()) {
            case "add" -> dbData = xInfo.infoLikeAdd(bao);
            case "del" -> dbData = xInfo.infoLikeDel(bao);
            case "get" -> {
                boolean bData = xInfo.infoLikeGet(bao);
                return ResponseEntity.ok()
                        .body(ReturnInfo.res(SUCCESS, "", bData));
            }
        }
        if (dbData > 0) {
            return ResponseEntity.ok()
                    .body(ReturnInfo.res(SUCCESS, "", "OK"));
        }

        return ResponseEntity.ok()
                .body(ReturnInfo.res(NOT_LOGGED_IN, "没有记录执行", null));

    }
    //用户点赞数量获取
    @PostMapping({"/user/like/countGet"})
    private ResponseEntity<ReturnInfo> userLikeCountGet(@Validated @RequestBody addLike bao) {
        boolean uTest = xUser.userByLoginTest(bao.getUser_number(),bao.getUser_login_key());
        if (!uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(KEY_ERROR, "请重新登陆", null));
        }
        int count = xInfo.infoLikeCount(bao);
        return ResponseEntity.ok()
                .body(ReturnInfo.res(SUCCESS, "", count));

    }
    //用户评分操作
    @PostMapping({"/user/pingfen/addGet"})
    private ResponseEntity<ReturnInfo> userPingfenAddGet(@Validated @RequestBody addPingfen bao) {
        boolean uTest = xUser.userByLoginTest(bao.getUser_number(),bao.getUser_login_key());
        if (!uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(KEY_ERROR, "请重新登陆", null));
        }
        if (bao.getType().equals("add")) {
            int dbData = xInfo.infoPingfenAdd(bao);
            if (dbData > 0) {
                return ResponseEntity.ok()
                        .body(ReturnInfo.res(SUCCESS, "", null));
            }
        } else if (bao.getType().equals("get")) {
            List<pingfenBean> rData = xInfo.infoPingfenGet(bao);
            if (rData.isEmpty()) {
                return ResponseEntity.ok()
                        .body(ReturnInfo.res(SUCCESS, "", null));
            }
            pingfenBean bean = rData.getFirst();
            return ResponseEntity.ok()
                    .body(ReturnInfo.res(SUCCESS, "", bean));
        }
        return ResponseEntity.ok()
                .body(ReturnInfo.res(SUCCESS, "没有记录执行", null));

    }

    //用户收藏操作
    @PostMapping({"/user/collection/addDelGet"})
    private ResponseEntity<ReturnInfo> userCollectionAdd(@Validated @RequestBody addCollection bao) {
        boolean uTest = xUser.userByLoginTest(bao.getUser_number(),bao.getUser_login_key());
        if (!uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(KEY_ERROR, "请重新登陆", null));
        }
        int dbData=0;
        switch (bao.getType()) {
            case "add" -> dbData = xInfo.infoCollectionAdd(bao);
            case "del" -> dbData = xInfo.infoCollectionDel(bao);
            case "get" -> {
                boolean bData = xInfo.infoCollectionGet(bao);
                return ResponseEntity.ok()
                        .body(ReturnInfo.res(SUCCESS, "", bData));
            }
        }
        if (dbData > 0) {
            return ResponseEntity.ok()
                    .body(ReturnInfo.res(SUCCESS, "", null));
        }

        return ResponseEntity.ok()
                .body(ReturnInfo.res(NOT_LOGGED_IN, "没有记录执行", null));

    }

    //获取用户所有收藏
    @PostMapping({"/user/collection/getAll"})
    private ResponseEntity<ReturnInfo> userCollectionGetAll(@Validated @RequestBody addCollection bao) {
        boolean uTest = xUser.userByLoginTest(bao.getUser_number(), bao.getUser_login_key());
        if (!uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(KEY_ERROR, "请重新登陆", null));
        }
        List<collectionBean> dbData = xInfo.infoCollectionGetAll(bao.getUser_number());
        if (!dbData.isEmpty()) {
            return ResponseEntity.ok()
                    .body(ReturnInfo.res(SUCCESS, "", dbData));
        }
        return ResponseEntity.ok()
                .body(ReturnInfo.res(NOT_LOGGED_IN, "没有收藏记录", null));
    }


    @PostMapping({"/user/comment/addDel"})
    private ResponseEntity<ReturnInfo> userCommentAdd(@Validated @RequestBody addComment bao) {
        boolean uTest = xUser.userByLoginTest(bao.getUser_number(), bao.getUser_login_key());
        if (!uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(KEY_ERROR, "请重新登陆", null));
        }
        int dbData=0;
        if (bao.getType().equals("add")) {
            dbData = xInfo.infoCommentAdd(bao);
        }else if (bao.getType().equals("del")){
            dbData = xInfo.infoCommentDel(bao);
        }
        if (dbData >0 ) {
            return ResponseEntity.ok()
                    .body(ReturnInfo.res(SUCCESS, "", null));
        }
        return ResponseEntity.ok()
                .body(ReturnInfo.res(NOT_LOGGED_IN, "操作失败", null));
    }


    //获取指定dataID所有评论
    @PostMapping({"/user/comment/getAll"})
    private ResponseEntity<ReturnInfo> userCommentGetAll(@Validated @RequestBody addComment bao) {
        boolean uTest = xUser.userByLoginTest(bao.getUser_number(), bao.getUser_login_key());
        if (!uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(KEY_ERROR, "请重新登陆", null));
        }
        List<commentBean> dbData = xInfo.infoCommentGetAll(bao.getData_id());
        if (!dbData.isEmpty()) {
            return ResponseEntity.ok()
                    .body(ReturnInfo.res(SUCCESS, "", dbData));
        }
        return ResponseEntity.ok()
                .body(ReturnInfo.res(NOT_LOGGED_IN, "没有评论", null));
    }

    //单独增加一个资源  前端未用,后台用
    @PostMapping({"/add"})
    private ResponseEntity<ReturnInfo> infoToAdd(@Validated @RequestBody addParams bao) {
        if (bao.getData_title() != null) {
            // 更新时间
            Date addTime = new Date();
            int dbData = xInfo.infoAdd(new addBean(
                    bao.getData_title(),
                    bao.getData_img_list(),
                    bao.getData_img_mx(),
                    bao.getData_url(),
                    bao.isData_good(),
                    bao.getData_dir(),
                    bao.getData_type(),
                    bao.getData_country(),
                    bao.getData_year(),
                    bao.getData_note(),
                    0,
                    0,
                    addTime));
            if (dbData>0) {
                return ResponseEntity.ok()
                        .body(ReturnInfo.res(SUCCESS, "", null));
            }
        }
        return ResponseEntity.ok()
                .body(ReturnInfo.res(NOT_LOGGED_IN, "", null));

    }
}
