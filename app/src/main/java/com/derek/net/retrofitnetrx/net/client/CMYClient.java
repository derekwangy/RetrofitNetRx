package com.derek.net.retrofitnetrx.net.client;



import com.derek.net.retrofitnetrx.entity.netbody.shop.GetServiceBody;
import com.derek.net.retrofitnetrx.entity.netbody.shop.GetVersionServiceBody;
import com.derek.net.retrofitnetrx.entity.netbody.shop.LoginBean;
import com.derek.net.retrofitnetrx.entity.netbody.shop.LoginServiceBody;
import com.derek.net.retrofitnetrx.entity.shop.Good;
import com.derek.net.retrofitnetrx.entity.shop.GuildPicBean;
import com.derek.net.retrofitnetrx.entity.shop.VersionBean;
import com.derek.net.retrofitnetrx.net.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */


public interface CMYClient {


    //版本
    @POST("api/v4/index/version")
    Observable<BaseResponse<VersionBean>> getVersionData();

    //登陆
    @POST("api/v4/login/do-login")
    Observable<BaseResponse<LoginBean>> getLogin(@Body LoginServiceBody loginServiceBody);

    //图片库
    @POST("api/v6/guide/pic")
    Observable<BaseResponse<GuildPicBean>> getGuildPicData();


    //http://testcgj.chemayi.com/
    @POST("sq580-store-api/goods/api/gethospitallist")
    Observable<BaseResponse<List<Good>>> getSocialShop(@Body GetServiceBody otherServiceBody);

    @POST("api/v4/index/version")
    Observable<BaseResponse<List<VersionBean>>> getVersionData1();

    @POST("api/v4/index/version")
    Observable<BaseResponse<List<VersionBean>>> getVersionInfo(@Body GetVersionServiceBody versionServiceBody);

}
