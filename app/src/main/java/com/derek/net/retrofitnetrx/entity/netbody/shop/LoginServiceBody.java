package com.derek.net.retrofitnetrx.entity.netbody.shop;

import com.google.gson.annotations.SerializedName;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */
public class LoginServiceBody {

    @SerializedName("DevType")
    private String DevType ;
    @SerializedName("Mobile")
    private String Mobile ;
    @SerializedName("Signature")
    private String Signature;
    @SerializedName("VerifyCode")
    private String VerifyCode;

    public LoginServiceBody(String DevType,String Mobile,String Signature,String VerifyCode){
        this.DevType = DevType;
        this.Mobile = Mobile;
        this.Signature = Signature;
        this.VerifyCode = VerifyCode;
    }



}
