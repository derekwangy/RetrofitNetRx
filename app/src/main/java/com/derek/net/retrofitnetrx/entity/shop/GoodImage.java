package com.derek.net.retrofitnetrx.entity.shop;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */
public class GoodImage implements Serializable {

    @SerializedName("goodId")
    private int goodId;
    @SerializedName("goodImage")
    private String goodImage;
    @SerializedName("goodImageId")
    private int goodImageId;
    @SerializedName("sort")
    private int sort;

    public GoodImage(String goodImage) {
        this.goodImage = goodImage;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodImage() {
        return goodImage;
    }

    public void setGoodImage(String goodImage) {
        this.goodImage = goodImage;
    }

    public int getGoodImageId() {
        return goodImageId;
    }

    public void setGoodImageId(int goodImageId) {
        this.goodImageId = goodImageId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "GoodImage{" +
                "sort=" + sort +
                ", goodImageId=" + goodImageId +
                ", goodImage='" + goodImage + '\'' +
                ", goodId=" + goodId +
                '}';
    }
}
