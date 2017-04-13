package com.derek.net.retrofitnetrx.entity.netbody.shop;

import com.google.gson.annotations.SerializedName;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */

public class GetServiceBody {

    @SerializedName("pageSize")
    private String pageSize = "10";
    @SerializedName("pageIndex")
    private String pageIndex;
    @SerializedName("longitude")
    private String longitude = "113.263292";
    @SerializedName("latitude")
    private String latitude = "23.382048";



    public GetServiceBody(String pageIndex) {
        this.pageIndex = pageIndex;
    }



    public GetServiceBody(String pageIndex,String name,String age) {
        this.pageIndex = pageIndex;
    }
}
