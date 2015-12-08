package com.bluecup.api;

import com.bluecup.model.CouponBO;

import java.util.List;

/**
 * Created by YUHONG on 2015/12/9.
 * Email: hongyuahu@gmail.com
 */
public class ApiImpl implements Api {
    private final static String APP_KEY = "ANDROID_KCOUPON";
    private final static String TIME_OUT_EVENT = "CONNECT_TIME_OUT";
    private final static String TIME_OUT_EVENT_MSG = "连接服务器失败";

    @Override
    public ApiResponse<Void> sendSmsCode4Register(String phoneNum) {
        return null;
    }

    @Override
    public ApiResponse<Void> registerByPhone(String phoneNum, String code, String password) {
        return null;
    }

    @Override
    public ApiResponse<Void> loginByApp(String loginName, String password, String imei, int loginOS) {
        return null;
    }

    @Override
    public ApiResponse<List<CouponBO>> listNewCoupon(int currentPage, int pageSize) {
        return null;
    }
}
