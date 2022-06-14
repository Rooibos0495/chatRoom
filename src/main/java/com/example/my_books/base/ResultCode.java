package com.example.my_books.base;
import lombok.Getter;
import lombok.Setter;
public enum ResultCode {
    // 成功
    SUCCESS (200, "成功"),
    // 失败
    FAIL (500, "失败"),
    // 未授权
    UNAUTHORIZED (401, ""),
    // 访问受限
    FORBIDDEN (403, "没有权限，请联系管理员授权"),
    // 接口不存在
    NOT_FOUND (404, "接口不存在"),
    // 服务器内部错误
    INTERNAL_SERVER_ERROR (500, "服务器内部错误，请联系管理员"),
    // 未知错误
    UNKNOW_ERROR (- 1, "未知错误，请联系管理员"),
    // 参数错误
    PARAM_IS_INVALID (10001, "参数无效");

    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String msg;


    ResultCode (Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}