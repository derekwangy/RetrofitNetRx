package com.derek.net.retrofitnetrx.net;

import com.google.gson.annotations.SerializedName;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */
public class PageWrapper<T> {

    @SerializedName("data")
    private T data;
    private int total;

    public PageWrapper(T data, int total) {
        this.data = data;
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "PageWrapper{" +
                "data=" + data +
                ", total=" + total +
                '}';
    }
}
