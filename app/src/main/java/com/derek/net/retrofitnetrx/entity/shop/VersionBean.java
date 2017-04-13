package com.derek.net.retrofitnetrx.entity.shop;

import java.io.Serializable;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */

public class VersionBean implements Serializable {

    /**
     * versionCode : 14
     * downloadUrl : http://7xiykt.com1.z0.glb.clouddn.com/chemayi_manager2.3.0@official.apk
     * updateContent :
     * forceUpdate : 0
     */
    private String versionCode;
    private String downloadUrl;
    private String updateContent;
    private String forceUpdate;

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public String getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(String forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

}