package com.zxl.demo.common.exception;

/**
 * <p>
 * </p>
 *
 * @author xianLing.zhou
 * @since 2019/3/5
 */
public class ErrorResponse {
    private int code;
    private String msg;

    public ErrorResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
