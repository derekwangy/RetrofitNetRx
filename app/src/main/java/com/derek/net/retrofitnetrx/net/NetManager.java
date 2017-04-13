package com.derek.net.retrofitnetrx.net;

import android.webkit.URLUtil;

import com.derek.net.retrofitnetrx.application.AppContext;
import com.derek.net.retrofitnetrx.net.base.DlException;
import com.derek.net.retrofitnetrx.net.client.CMYClient;
import com.derek.net.retrofitnetrx.util.AppUtil;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.derek.net.retrofitnetrx.net.HttpUrl.REQUEST_URL;
import static com.derek.net.retrofitnetrx.net.base.ErrorCode.NET_DISABLE;


/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */
public enum NetManager {

    INSTANCE;

    private CMYClient mCMYClient;

    public void initNetClient() {
        OkHttpClient.Builder mOkHttpClient = new OkHttpClient.Builder();
        Retrofit.Builder mRetrofit = new Retrofit.Builder();
        setCommonSetting(mOkHttpClient, mRetrofit, REQUEST_URL);
        mCMYClient = mRetrofit.client(mOkHttpClient.build()).build().create(CMYClient.class);
    }

    private void setCommonSetting(OkHttpClient.Builder okhttpBuilder, Retrofit.Builder retrofitBuilder, String hostUrl) {
        setCommonSetting(okhttpBuilder, retrofitBuilder, hostUrl, 10, 10, 10);
    }

    private void setCommonSetting(OkHttpClient.Builder okhttpBuilder, Retrofit.Builder retrofitBuilder, String hostUrl,
                                  int conTimeout, int writeTimeout, int readTimeout) {
        if (!URLUtil.isValidUrl(hostUrl)) {
            throw new IllegalArgumentException("please setup the validUrl");
        } else {
            retrofitBuilder.baseUrl(hostUrl);
        }
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        okhttpBuilder.connectTimeout(conTimeout, TimeUnit.SECONDS);
        okhttpBuilder.writeTimeout(writeTimeout, TimeUnit.SECONDS);
        okhttpBuilder.readTimeout(readTimeout, TimeUnit.SECONDS);

        //常用参数拦截器
        ParamsInterceptor paramsInterceptor = new ParamsInterceptor();
        okhttpBuilder.addInterceptor(paramsInterceptor);

        //日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okhttpBuilder.addInterceptor(loggingInterceptor);

        okhttpBuilder.addInterceptor(chain -> {
            if (AppUtil.isNetworkAvailable(AppContext.getInstance())) {
                return chain.proceed(chain.request());
            } else {
                throw new DlException(NET_DISABLE, "网络连接失败，请开启您的网络连接，并重试！");
            }
        });
    }

    public CMYClient getShopClient() {
        return mCMYClient;
    }
}
