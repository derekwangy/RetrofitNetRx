package com.derek.net.retrofitnetrx.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.derek.net.retrofitnetrx.R;
import com.derek.net.retrofitnetrx.entity.netbody.shop.LoginBean;
import com.derek.net.retrofitnetrx.entity.netbody.shop.LoginServiceBody;
import com.derek.net.retrofitnetrx.entity.shop.GuildPicBean;
import com.derek.net.retrofitnetrx.entity.shop.VersionBean;
import com.derek.net.retrofitnetrx.net.DlObserve;
import com.derek.net.retrofitnetrx.net.NetManager;
import com.derek.net.retrofitnetrx.net.NetUtil;
import com.derek.net.retrofitnetrx.ui.base.BaseActivity;


public class TextActivity extends BaseActivity implements View.OnClickListener{
    public static String token = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_test_details);
        initListener();
    }

    private void initListener() {
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnVersion).setOnClickListener(this);
        findViewById(R.id.btnGuildPic).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                if (!TextUtils.isEmpty(TextActivity.token)){
                    Toast.makeText(TextActivity.this,"已登陆",Toast.LENGTH_LONG).show();
                }else {
//                    login();
                }
                break;
            case R.id.btnVersion:
                getVersionData();
                break;
            case R.id.btnGuildPic:
                getGuidPicData();
                break;
        }
    }

    private void login(){
        //http://testcgj.chemayi.com/api/v4/login/do-login
        String DevType = "android";
        String Mobile = "13000000008";
        String Signature = "0d4c3c606fab0047e122b346661b181d";
        String VerifyCode = "059814";

        NetManager.INSTANCE.getShopClient().getLogin(new LoginServiceBody(DevType,Mobile,Signature,VerifyCode))
                .compose(bindToLifecycle())
                .compose(NetUtil.handleResult())
                .subscribe(new DlObserve<LoginBean>(){
                    @Override
                    public void onResponse(LoginBean versionBean) {
                        String ss = versionBean.toString();
                        if (versionBean != null){
                            token = versionBean.getToken();
                        }
                        Log.i("TAG-token:",""+token);
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });
    }

    private void getVersionData(){

        NetManager.INSTANCE.getShopClient().getVersionData()
                .compose(bindToLifecycle())
                            .compose(NetUtil.handleResult())
                            .subscribe(new DlObserve<VersionBean>(){

                        @Override
                        public void onResponse(VersionBean versionBean) {
                            String ss = versionBean.toString();
                            Log.i("TAG:",""+versionBean.getDownloadUrl());
                            Log.i("TAG:",""+versionBean.getUpdateContent());
                        }

                        @Override
                        public void onError(int errorCode, String errorMsg) {

                        }
                });
    }

    private void getGuidPicData(){

        NetManager.INSTANCE.getShopClient().getGuildPicData()
                .compose(bindToLifecycle())
                .compose(NetUtil.handleResult())
                .subscribe(new DlObserve<GuildPicBean>(){

                    @Override
                    public void onResponse(GuildPicBean versionBean) {
                        String ss = versionBean.toString();
                        Log.i("TAG:",""+versionBean.getImg());
                        Log.i("TAG:",""+versionBean.getEndTime());
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });
    }

}
