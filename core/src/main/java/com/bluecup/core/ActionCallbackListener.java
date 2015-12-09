package com.bluecup.core;

/**
 * action 处理结果向上回调
 * Created by YUHONG on 2015/12/9.
 * Email: hongyuahu@gmail.com
 */
public interface ActionCallbackListener<T> {
    /**
     * 成功时调用
     * @param data  返回的数据
     */
    public void onSuccess(T data);

    /**
     * 失败时调用
     * @param errorEvent    错误码
     * @param message       错误信息
     */
    public void onFailure(String errorEvent, String message);
}
