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
//    @SerializedName("versionCode")
    private String versionCode;
//    @SerializedName("downloadUrl")
    private String downloadUrl;
//    @SerializedName("updateContent")
    private String updateContent;
//    @SerializedName("forceUpdate")
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


//    /**
//     * flag : 1
//     * msg : 成功
//     * data : {"versionCode":"14","downloadUrl":"http://7xiykt.com1.z0.glb.clouddn.com/chemayi_manager2.3.0@official.apk","updateContent":"","forceUpdate":"0"}
//     * hanDefaultCar : true
//     */
//    @SerializedName("flag")
//    private int flag;
//    @SerializedName("msg")
//    private String msg;
//    @SerializedName("data")
//    private DataBean data;
//    @SerializedName("hanDefaultCar")
//    private boolean hanDefaultCar;
//
//    public int getFlag() {
//        return flag;
//    }
//
//    public void setFlag(int flag) {
//        this.flag = flag;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public boolean isHanDefaultCar() {
//        return hanDefaultCar;
//    }
//
//    public void setHanDefaultCar(boolean hanDefaultCar) {
//        this.hanDefaultCar = hanDefaultCar;
//    }
//
//    public static class DataBean {
//        /**
//         * versionCode : 14
//         * downloadUrl : http://7xiykt.com1.z0.glb.clouddn.com/chemayi_manager2.3.0@official.apk
//         * updateContent :
//         * forceUpdate : 0
//         */
//        @SerializedName("versionCode")
//        private String versionCode;
//        @SerializedName("downloadUrl")
//        private String downloadUrl;
//        @SerializedName("updateContent")
//        private String updateContent;
//        @SerializedName("forceUpdate")
//        private String forceUpdate;
//
//        public String getVersionCode() {
//            return versionCode;
//        }
//
//        public void setVersionCode(String versionCode) {
//            this.versionCode = versionCode;
//        }
//
//        public String getDownloadUrl() {
//            return downloadUrl;
//        }
//
//        public void setDownloadUrl(String downloadUrl) {
//            this.downloadUrl = downloadUrl;
//        }
//
//        public String getUpdateContent() {
//            return updateContent;
//        }
//
//        public void setUpdateContent(String updateContent) {
//            this.updateContent = updateContent;
//        }
//
//        public String getForceUpdate() {
//            return forceUpdate;
//        }
//
//        public void setForceUpdate(String forceUpdate) {
//            this.forceUpdate = forceUpdate;
//        }
//    }
}
