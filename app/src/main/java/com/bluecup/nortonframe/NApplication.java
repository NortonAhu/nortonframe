package com.bluecup.nortonframe;

import android.app.Application;

import com.bluecup.core.AppAction;
import com.bluecup.core.AppActionImpl;

/**
 * Application 类，应用级别的操作都在这
 * Created by YUHONG on 2015/12/9.
 * Email: hongyuahu@gmail.com
 */
public class NApplication extends Application {

    private AppAction appAction;
    @Override
    public void onCreate() {
        super.onCreate();
        appAction = new AppActionImpl(this);
    }

    public AppAction getAppAction() {
        return appAction;
    }
}
