package com.heycolor.yunziyuanbackend.constant;

/**
 * @author LunKeee
 * 2024/11/26 4:43
 * 全局状态码
 */

public enum StateCode {

    SUCCESS(200,"success"),
    FAILED(400,"权限不足 - "),  //权限不足
    REQUEST_METHOD_ERROR(401,"缺少参数 - "),  //请求方法不支持
    NOT_LOGGED_IN(402,"请求失败 - "),
    KEY_ERROR(403,"异地登陆 - "), //权限不足，提交参数不存在
    UNKNOWN_EXCEPTION(500,"请求失败 - "),
    SERVICE_UNRESPONSIVE(501,"请求失败 - "),
    DATABASE_UNRESPONSIVE(502,"请求失败 - ");

    //状态码
    final int code;
    //状态说明
    final String message;

    StateCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
