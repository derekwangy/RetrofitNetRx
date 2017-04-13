package com.derek.net.retrofitnetrx.net;


import android.text.TextUtils;


import com.derek.net.retrofitnetrx.ui.TextActivity;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */
public class ParamsInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();

        long timeStamp = System.currentTimeMillis();
        String timestamp = String.valueOf(timeStamp);

        FormBody body =getFormBody();

        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(oldRequest.url())
                .headers(oldRequest.headers())
                .addHeader("AppVersion", "4.3.0")//工具类自己获取
                .post(body)
                .build();
        return chain.proceed(newRequest);
    }

    public FormBody getFormBody() {
        long timeStamp = System.currentTimeMillis();
        String timestamp = String.valueOf(timeStamp);
        FormBody.Builder builder = new FormBody.Builder();
//        SortedMap<String, String> jsonParams = getSortedParams(request);
//        Iterator<String> iterator = jsonParams.keySet().iterator();
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            String value = jsonParams.get(key);
//            builder.add(key, value);
//        }
        builder.add("VersionName","4.3.0");
        builder.add("Signature","0d4c3c606fab0047e122b346661b181d");
        builder.add("System","1");
        builder.add("tms",timestamp);
        if (!TextUtils.isEmpty(TextActivity.token)){
            builder.add("Token",TextActivity.token);
        }
        return builder.build();
    }
}
