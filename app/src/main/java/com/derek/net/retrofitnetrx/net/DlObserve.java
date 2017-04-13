package com.derek.net.retrofitnetrx.net;


import com.derek.net.retrofitnetrx.net.base.BaseObserver;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */
public abstract class DlObserve<T> extends BaseObserver<T> {

    @Override
    public void handleError(int errorCode, String errorMsg) {
        try {
            //需要进行一层全局的拦截.例如登录信息过期等全局弹框
            onError(errorCode, errorMsg);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            onAfter();
        }
    }

    @Override
    public void onNext(T t) {
        onResponse(t);
    }

    public void onAfter() {
    }

    public abstract void onResponse(T t);

    public abstract void onError(int errorCode, String errorMsg);
}
