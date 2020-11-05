package com.cl.demo.enums;

import lombok.Getter;

/**
 * @author cl
 * @description 响应码枚举
 */
@Getter
public enum ResultCode {

    /**
     * 操作成功
     */
    SUCCESS(1000, "操作成功"),

    /**
     * 响应失败
     */
    FAILED(1001, "响应失败"),

    /**
     * 参数校验失败
     */
    VALIDATE_FAILED(1002, "参数校验失败"),

    /**
     * 未知错误
     */
    ERROR(5000, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
