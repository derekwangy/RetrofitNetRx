package com.derek.net.retrofitnetrx.net;

import android.util.Log;
import android.webkit.URLUtil;

import com.derek.net.retrofitnetrx.application.AppContext;
import com.derek.net.retrofitnetrx.net.base.DlException;
import com.derek.net.retrofitnetrx.net.client.CMYClient;
import com.derek.net.retrofitnetrx.util.AppUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
        mOkHttpClient.cache(getCache());
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

        //缓存拦截器
        okhttpBuilder.addInterceptor(getCacheIntercepter());


        okhttpBuilder.addInterceptor(chain -> {
            if (AppUtil.isNetworkAvailable(AppContext.getInstance())) {
                return chain.proceed(chain.request());
            } else {
                throw new DlException(NET_DISABLE, "网络连接失败，请开启您的网络连接，并重试！");
            }
        });
    }


    private Cache getCache(){
        //cache url
        File httpCacheDirectory = new File(AppUtil.getFileCache(AppContext.getInstance()), "responsesCahce");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(httpCacheDirectory, cacheSize);
    }

    /**
     * 缓存拦截器
     * @return
     */
    private Interceptor getCacheIntercepter(){
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.i("NET:","进入缓存拦截器");

                //无网络状态走缓存
                if (!AppUtil.isNetworkReachable(AppContext.getInstance())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .url(request.url()).build();
                    new DlException(NET_DISABLE, "网络连接失败，请开启您的网络连接，并重试！");
                    Log.i("NET:","进入缓存");
                }

                //设置缓存存放时间
                Response response = chain.proceed(request);
                if (AppUtil.isNetworkReachable(AppContext.getInstance())) {
                    int maxAge = 60 * 60; // read from cache for 1 minute
                    response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .build();
                } else {
                    int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                    response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .build();
                }
                return response;
            }
        };
        return cacheInterceptor;
    }

    public CMYClient getShopClient() {
        return mCMYClient;
    }
}
