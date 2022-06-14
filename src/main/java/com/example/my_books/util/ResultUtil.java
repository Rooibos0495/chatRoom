package com.example.my_books.util;

import com.example.my_books.base.Result;
import com.example.my_books.base.ResultCode;

public class ResultUtil {
    /**
     * 返回成功，传入返回体具体出參
     *
     * @param object
     * @return
     */
    public static <T> Result<T> success (T object) {
        Result<T> result = new Result<T> ();
        result.setStatus (ResultCode.SUCCESS.getCode ());
        result.setMsg (ResultCode.SUCCESS.getMsg ());
        result.setData (object);
        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     *
     * @return
     */
    public static <T> Result<T> success () {
        return success (null);
    }

    /**
     * 自定义错误信息
     *
     * @param code
     * @param msg
     * @return
     */
    public static <T> Result<T> error (Integer code, String msg) {
        return errorWithData (code, msg, null);
    }

    /**
     * 自定义错误信息
     *
     * @param msg
     * @return
     */
    public static <T> Result<T> error (String msg) {
        return errorWithData (500, msg, null);
    }

    /**
     * 返回异常信息，在已知的范围内
     *
     * @param resultCode
     * @return
     */
    public static <T> Result<T> error (ResultCode resultCode) {
        return errorWithData (resultCode.getCode (), resultCode.getMsg (), null);
    }

    /**
     * 自定义错误信息
     *
     * @param code
     * @param msg
     * @return
     */
    public static <T> Result<T> errorWithData (Integer code, String msg, T object) {
        Result<T> result = new Result<T> ();
        result.setStatus (code);
        result.setMsg (msg);
        result.setData (object);
        return result;
    }

    /**
     * 是否成功
     * @param result
     * @return
     */
    public static boolean isSuccess (Result<?> result) {
        return result != null && ResultCode.SUCCESS.getCode ().equals (result.getStatus ());
    }
}
