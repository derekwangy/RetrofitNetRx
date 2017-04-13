package com.derek.net.retrofitnetrx.net;

import com.google.gson.annotations.SerializedName;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */
public class BaseResponse<T> {
    /**
     * flag : 1
     * msg : 成功
     * data : {"versionCode":"14","downloadUrl":"http://7xiykt.com1.z0.glb.clouddn.com/chemayi_manager2.3.0@official.apk","updateContent":"","forceUpdate":"0"}
     * hanDefaultCar : false
     */

    @SerializedName("flag")
    private int flag = -1;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private T data;
    @SerializedName("hanDefaultCar")
    private boolean hanDefaultCar;

    @SerializedName("total")
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
//    public int getErrorCode() {
//        return mErrorCode;
//    }
//
//    public void setErrorCode(int flag) {
//        this.mErrorCode = flag;
//    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isHanDefaultCar() {
        return hanDefaultCar;
    }

    public void setHanDefaultCar(boolean hanDefaultCar) {
        this.hanDefaultCar = hanDefaultCar;
    }


    /**
     * {
     "flag": 1,
     "msg": "成功",
     "data": {
     "TestScore": 0,
     "notifications": [{
     "NotificationID": "17",
     "Title": "维修咨询，在线解决",
     "Type": "6",
     "Url": "native1",
     "ServiceID": "",
     "UnitePayID": "",
     "ServiceProductID": "",
     "CanIgnore": "1"
     }],
     "NewMessage": 0,
     "OilRechargeIsOpen": true,
     "isInsurance": "1"
     },
     "hanDefaultCar": false
     }
     */













//    @SerializedName("flag")
//    private int mErrorCode = -1;
//    @SerializedName("msg")
//    private String mMsg;
//    @SerializedName("data")
//    private T data;
//
//    @SerializedName("total")
//    private int total;
//
//    public int getErrorCode() {
//        return mErrorCode;
//    }
//
//    public void setErrorCode(int errorCode) {
//        mErrorCode = errorCode;
//    }
//
//    public String getMsg() {
//        return mMsg;
//    }
//
//    public void setMsg(String msg) {
//        mMsg = msg;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public int getTotal() {
//        return total;
//    }
//
//    public void setTotal(int total) {
//        this.total = total;
//    }
//
//    @Override
//    public String toString() {
//        return "BaseResponse{" +
//                "mErrorCode=" + mErrorCode +
//                ", mMsg='" + mMsg + '\'' +
//                ", data=" + data +
//                ", total=" + total +
//                '}';
//    }
}
