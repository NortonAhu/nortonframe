package com.bluecup.core;

import com.bluecup.model.CouponBO;

import java.util.List;

/**
 * 核心层处于接口层和界面之间向下调用 API ，向上发送 Action。核心任务就是处理复杂的业务逻辑
 * Created by YUHONG on 2015/12/9.
 * Email: hongyuahu@gmail.com
 */
public interface AppAction {

    /**
     * 发送验证码
     * @param phoneNum  手机号码
     * @param listener  回调监听器
     */
    public void sendSmsCode(String phoneNum, ActionCallbackListener<Void> listener);

    /**
     * 注册账户
     * @param phoneNum  手机号码
     * @param code      验证码
     * @param password  密码
     * @param listener  回调监听器
     */
    public void register(String phoneNum, String code, String password, ActionCallbackListener<Void> listener);

    /**
     * 登录
     * @param phoneNum  手机号
     * @param password  密码
     * @param listener  回调监听器
     */
    public void login(String phoneNum, String password,ActionCallbackListener<Void> listener);

    /**
     * 券票列表
     * @param currentPage   当前页码
     * @param listener      回调监听器
     */
    public void listCoupon(int currentPage,ActionCallbackListener<List<CouponBO>> listener);

}
