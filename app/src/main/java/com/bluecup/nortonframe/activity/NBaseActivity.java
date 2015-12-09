package com.bluecup.nortonframe.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bluecup.core.AppAction;
import com.bluecup.nortonframe.NApplication;

/**
 * Activity 基类
 * Created by YUHONG on 2015/12/9.
 * Email: hongyuahu@gmail.com
 */
public abstract class NBaseActivity extends AppCompatActivity {
    // 上下文实例
    protected Context context;
    // 系统全局变量
    protected NApplication application;
    // 核心层 Action 实例
    protected AppAction appAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        application = (NApplication)this.getApplication();
        appAction = application.getAppAction();
    }

    /**
     * 初始化界面
     */
    protected abstract void initViews();
}
