package com.bluecup.core;

/**
 * 错误码
 * Created by YUHONG on 2015/12/9.
 * Email: hongyuahu@gmail.com
 */
public class ErrorEvent {
    // 1 开头表示客户端错误
    static final String PARAM_NULL = "1000"; // 参数为空
    static final String PARAM_ILLEGAL = "1001"; // 参数不合法

    // 错误中文描述
    static final String PARAM_NUll_PHONENUM_MSG = "手机号为空";
    static final String PARAM_ILLEGAL_PHONENUM_MSG = "手机号不正确";
}
