package com.example.my_books.common;

import java.io.Serializable;

public class ResponseMsg implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private boolean isSuccess = true;
    private int errorCode = 0;
    private String msg;
    private Object data;

    public ResponseMsg() {
    }

    public ResponseMsg(boolean isSucces) {
        this.isSuccess = isSucces;
    }

    public ResponseMsg(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public ResponseMsg(boolean isSuccess, Object data) {
        this.isSuccess = isSuccess;
        this.data = data;
    }

    public ResponseMsg(boolean isSucces, int errorCode, String msg) {
        this.isSuccess = isSucces;
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public ResponseMsg setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ResponseMsg setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseMsg setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseMsg setData(Object data) {
        this.data = data;
        return this;
    }
    public static ResponseMsg ok() {
        ResponseMsg msg = new ResponseMsg();
        msg.setSuccess(true);
        return msg;
    }
    public static ResponseMsg ok(Object data) {
        ResponseMsg msg = new ResponseMsg();
        msg.setSuccess(true).setData(data);
        return msg;
    }
    public static ResponseMsg ok(Object data, String msgstr) {
        ResponseMsg msg = new ResponseMsg();
        msg.setSuccess(true).setData(data).setMsg(msgstr);
        return msg;
    }
    public static ResponseMsg fail(String msgstr) {
        ResponseMsg msg = new ResponseMsg();
        msg.setSuccess(false).setMsg(msgstr);
        return msg;
    }
//	public static ResponseMsg fail(Object data, String msgstr) {
//		ResponseMsg msg = new ResponseMsg();
//		msg.setSuccess(false).setData(data).setMsg(msgstr);
//		return msg;
//	}

}
