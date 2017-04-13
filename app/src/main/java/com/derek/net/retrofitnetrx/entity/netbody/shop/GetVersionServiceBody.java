package com.derek.net.retrofitnetrx.entity.netbody.shop;

import com.google.gson.annotations.SerializedName;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */
public class GetVersionServiceBody {

    @SerializedName("AppVersion")
    private String AppVersion ;
    @SerializedName("Signature")
    private String Signature ;
    @SerializedName("System")
    private String System;

    public GetVersionServiceBody(String AppVersion,String Signature,String System){
        this.AppVersion = AppVersion;
        this.Signature = Signature;
        this.System = System;
    }


    //    @SerializedName("AppVersion")
//    private String AppVersion = "4.3.0";
//    @SerializedName("Signature")
//    private String Signature = "9cf154aa65b680602111344d6c516db5";
//    @SerializedName("System")
//    private String System = "1";

}
