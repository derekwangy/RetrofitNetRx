package com.derek.net.retrofitnetrx.net;


import com.derek.net.retrofitnetrx.net.base.DlException;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */
public class NetUtil {

    private static final int RESULT_CODE = 1; //请求返回值

    public static <T> ObservableTransformer<BaseResponse<T>, T> handleResult() {
        try {
            return baseResponseObservable -> baseResponseObservable
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(baseResponse -> {
                        if (baseResponse.getFlag() == RESULT_CODE) {
                            if (baseResponse.getData() != null) {
                                return Observable.just(baseResponse.getData());
                            } else {
                                //这种情况是没有data的情况下需要走onComplete来进行处理
                                return Observable.empty();
                            }
                        } else {
                            return Observable.error(new DlException(baseResponse.getFlag(), baseResponse.getMsg()));
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
            return baseResponseObservable -> baseResponseObservable
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(baseResponse -> Observable.error(new Throwable("服务器错误")));
        }
    }

    public static <T> ObservableTransformer<BaseResponse<T>, PageWrapper<T>> handleResultWithTotal() {
        try {
            return baseResponseObservable -> baseResponseObservable
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(baseResponse -> {
                        if (baseResponse.getFlag() == RESULT_CODE) {
                            if (baseResponse.getData() != null) {
                                PageWrapper<T> pageWrapper = new PageWrapper<>(baseResponse.getData(), baseResponse.getTotal());
                                return Observable.just(pageWrapper);
                            } else {
                                return Observable.empty();
                            }
                        } else {
                            return Observable.error(new DlException(baseResponse.getFlag(), baseResponse.getMsg()));
                        }
                    });
        } catch (Exception e) {
            return baseResponseObservable -> baseResponseObservable
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(tBaseResponse -> Observable.error(new Throwable("服务器错误")));
        }
    }

    public static MultipartBody.Part[] getPartByMap(Map<String, String> stringMap) {
        MultipartBody.Part[] parts = new MultipartBody.Part[stringMap.size()];
        int i = 0;
        for (String key : stringMap.keySet()) {
            parts[i++] = MultipartBody.Part.createFormData(key, stringMap.get(key));
        }
        return parts;
    }
}
