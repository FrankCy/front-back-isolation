package com.fbi.cloud.api.util;

import java.io.Serializable;

/**
 *
 *
 * @author cy
 * @version ResultUtil.java, v 0.1 2020年09月16日 09:04 cy Exp $
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 5964664300127915834L;

    public Result(boolean success, int code) {
        this.setSuccess(success);
        this.setCode(code);
    }

    public Result(boolean success, int code, T data) {
        this.setSuccess(success);
        this.setCode(code);
        this.setData(data);
    }

    public Result(boolean success, int code, T data, String msg) {
        this.setSuccess(success);
        this.setCode(code);
        this.setData(data);
        this.setMsg(msg);
    }

    public Result(boolean success, int code, String msg) {
        this.setSuccess(success);
        this.setCode(code);
        this.setMsg(msg);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 请求是否成功
     * true:成功
     * false：失败
     */
    private boolean success;

    /**
     * 状态码
     * 成功：200
     * 失败：其他
     */
    private int code;

    /**
     * 失败状态码描述
     * 如果成功不返回
     * 失败返回状态码对应的msg消息
     */
    private String msg;

    /**
     * 请求数据的结果
     */
    private T data;


    public static <T> Result<T> success() {
        return new Result<T>(true, HttpStatusEnum.OK.code());
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(true, HttpStatusEnum.OK.code(), data);
    }

    public static <T> Result<T> success(T data, String msg) {
        return new Result<T>(true, HttpStatusEnum.OK.code(), data, msg);
    }

    public static <T> Result<T> fail(HttpStatusEnum httpStatusEnum) {
        return new Result<T>(false, httpStatusEnum.code(), httpStatusEnum.reasonPhraseUS());
    }

    public static <T> Result<T> fail(HttpStatusEnum httpStatusEnum, String msg) {
        return new Result<T>(false, httpStatusEnum.code(), msg);
    }


}