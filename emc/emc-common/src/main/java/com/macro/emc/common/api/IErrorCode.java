package com.macro.emc.common.api;

/**
 * 封装API的错误码
 * Created by jane on 2022/4/19.
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
