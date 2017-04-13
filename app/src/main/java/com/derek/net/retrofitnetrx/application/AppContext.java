package com.derek.net.retrofitnetrx.application;

import android.app.Application;

import com.derek.net.retrofitnetrx.net.NetManager;
import com.derek.net.retrofitnetrx.util.PixelUtil;


/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */

public class AppContext extends Application {

    public static AppContext mInstance;

    public static AppContext getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        //初始化shop的请求
        NetManager.INSTANCE.initNetClient();
        //初始化单位转换
        PixelUtil.init(this);
    }
}
