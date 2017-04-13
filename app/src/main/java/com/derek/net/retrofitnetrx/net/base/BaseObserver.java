package com.derek.net.retrofitnetrx.net.base;

import android.net.ParseException;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

import static com.derek.net.retrofitnetrx.net.base.ErrorCode.EXCHANGE_DATA_ERROR;
import static com.derek.net.retrofitnetrx.net.base.ErrorCode.HTTP_EXCEPTION;
import static com.derek.net.retrofitnetrx.net.base.ErrorCode.INTERRUPTED_IOEXCEPTION;
import static com.derek.net.retrofitnetrx.net.base.ErrorCode.OTHER_IOEXCEPTION;
import static com.derek.net.retrofitnetrx.net.base.ErrorCode.UNKONW_EXCEPTION;


/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */
public abstract class BaseObserver<T> extends DisposableObserver<T> {

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onError(Throwable throwable) {

        if (throwable instanceof IOException) {
            if (throwable instanceof UnknownHostException) {
                //服务器异常
                handleError(INTERRUPTED_IOEXCEPTION, "网络异常，请稍后重试");
            } else if (throwable instanceof InterruptedIOException) {
                //超时异常
                handleError(INTERRUPTED_IOEXCEPTION, "网络异常，请稍后重试");
            } else {
                handleError(OTHER_IOEXCEPTION, "网络异常，请稍后重试");
            }
        } else if (throwable instanceof HttpException) {
            //retrofit请求木有返回
            handleError(HTTP_EXCEPTION, "网络异常，请稍后重试");
        } else if (throwable instanceof JsonParseException
                || throwable instanceof JSONException
                || throwable instanceof ParseException) {
            //解释数据错误
            handleError(EXCHANGE_DATA_ERROR, "解释数据错误");
        } else if (throwable instanceof DlException) {
            DlException dlException = (DlException) throwable;
            handleError(dlException.getErrorCode(), dlException.getErrorMessage());
        } else {
            handleError(UNKONW_EXCEPTION, "网络异常，请稍后重试");
        }
    }

    @Override
    public void onComplete() {
    }

    public abstract void handleError(int errorCode, String errorMsg);

}
