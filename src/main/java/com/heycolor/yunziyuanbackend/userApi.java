package com.heycolor.yunziyuanbackend;

import com.heycolor.yunziyuanbackend.DAOuser.Request.upPswParams;
import com.heycolor.yunziyuanbackend.constant.ReturnInfo;
import com.heycolor.yunziyuanbackend.service.userService;
import com.heycolor.yunziyuanbackend.DAOuser.Request.loginParams;
import com.heycolor.yunziyuanbackend.DAOuser.Request.upInfoParams;
import com.heycolor.yunziyuanbackend.DAOuser.loginBean;
import com.heycolor.yunziyuanbackend.DAOuser.userBean;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

import static com.heycolor.yunziyuanbackend.constant.StateCode.*;

@RequestMapping("/user")
@RestController
public class userApi {
    private final userService xUser;

    public userApi(userService xUser) {
        this.xUser = xUser;
    }

    @PostMapping({"/userLogin"})
    private ResponseEntity<ReturnInfo> userToLogin(@Validated @RequestBody loginParams bao) {
        userBean dbData = xUser.userByLogin(bao.getUser_number(),bao.getUser_psw());
        if (dbData == null) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(FAILED, "用户不存在或密码错误", null));
        }

        if ("管理员".equals(bao.getUser_type()) && !dbData.getUser_type().equals("1")) {
            return ResponseEntity.badRequest().body(ReturnInfo.res(FAILED, "非管理员用户", null));
        }

        //生成登陆关键词
        String user_login_key = generateRandomKey(16);
        // 登录成功，返回用户信息
        loginBean userInfo = new loginBean(
                dbData.getUser_number(),
                dbData.getUser_name(),
                dbData.getUser_type(),
                dbData.getUser_tx(),
                dbData.getUser_state(),
                dbData.getUser_aihao(),
                dbData.getUser_points(),
                user_login_key);

        // 更新登陆时间
        Date login_time = new Date();
        xUser.upLoginTimer(dbData.getId(), user_login_key, login_time);

        return ResponseEntity.ok()
                .body(ReturnInfo.res(SUCCESS, "", userInfo));
    }

    @PostMapping({"/userManagerAdd"})
    private ResponseEntity<ReturnInfo> userManagerAdd(@Validated @RequestBody loginParams bao) {
        boolean uTest = xUser.userByTest(bao.getUser_number());
        if (uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(NOT_LOGGED_IN, "用户账号已存在", null));
        }

        // 更新登陆时间
        Date mTime = new Date();
        xUser.userByReg(bao.getUser_number(), bao.getUser_psw(), "还未设置名称",1, "头像",1,"",0,"", mTime);
        return ResponseEntity.ok()
                .body(ReturnInfo.res(SUCCESS, "", null));
    }

    @PostMapping({"/userReg"})
    private ResponseEntity<ReturnInfo> userToReg(@Validated @RequestBody loginParams bao) {
        boolean uTest = xUser.userByTest(bao.getUser_number());
        if (uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(NOT_LOGGED_IN, "用户账号已存在", null));
        }

        // 更新登陆时间
        Date mTime = new Date();
        xUser.userByReg(bao.getUser_number(), bao.getUser_psw(), "还未设置名称",0, "头像",1,"",0,"", mTime);
        return ResponseEntity.ok()
                .body(ReturnInfo.res(SUCCESS, "", null));
    }

    @PostMapping({"/upInfo"})
    private ResponseEntity<ReturnInfo> userInfoToUpDate(@Validated @RequestBody upInfoParams bao) {
        boolean uTest = xUser.userByLoginTest(bao.getUser_number(),bao.getUser_login_key());
        if (!uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(KEY_ERROR, "请重新登陆", null));
        }
        if (bao.getValue() != null && bao.getType() != null) {
            int iReturn = switch (bao.getType()) {
                case "user_name" -> xUser.upUserInfo(bao.getUser_number(), null, bao.getValue(), null, null);
                case "user_tx" -> xUser.upUserInfo(bao.getUser_number(), null, null, bao.getValue(), null);
                case "user_aihao" -> xUser.upUserInfo(bao.getUser_number(), null, null, null, bao.getValue());
                default -> 0;
            };

            if (iReturn > 0) {
                return ResponseEntity.ok()
                        .body(ReturnInfo.res(SUCCESS, "", null));
            }
        }
        // 更新
        return ResponseEntity.ok()
                .body(ReturnInfo.res(REQUEST_METHOD_ERROR, "请检查请求是否正确", null));

    }

    @PostMapping({"/upPsw"})
    private ResponseEntity<ReturnInfo> userInfoToUpDate(@Validated @RequestBody upPswParams bao) {
        boolean uTest = xUser.userByLoginTest(bao.getUser_number(), bao.getUser_login_key());
        if (!uTest) {
            return ResponseEntity.badRequest()
                    .body(ReturnInfo.res(KEY_ERROR, "请重新登陆", null));
        }
        int r = xUser.upUserPsw(bao);
        if (r > 0) {
            return ResponseEntity.ok()
                    .body(ReturnInfo.res(SUCCESS, "", null));
        }
        return ResponseEntity.badRequest()
                .body(ReturnInfo.res(NOT_LOGGED_IN, "用户账号和旧密码不匹配", null));
    }



    // 定义字符池（字母和数字）
    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // 生成随机字符串
    public static String generateRandomKey(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // 从字符池中随机选择一个字符
            int index = random.nextInt(CHAR_POOL.length());
            sb.append(CHAR_POOL.charAt(index));
        }
        return sb.toString();
    }

}
