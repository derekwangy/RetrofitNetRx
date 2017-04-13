package com.derek.net.retrofitnetrx.entity.netbody.shop;

/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */

public class LoginBean {

    /**
     * MemberID : 79930
     * Token : 58de2d036f55e
     * Instime : 2017-03-31 18:18:43
     * wukong : {"success":true,"imSignModel":{"domain":"startest","appKey":"1da88a74d37bfd74800ff034cfcea384","nonce":"NHAEmT","timestamp":1491989212,"signature":"613ed225cd4b45541d59f377adf9b1cc8cb1d595ff811bb5c9afc27109191be1","openId":"79930"}}
     * ExistDefaultCarModel : 1
     */

    private String MemberID;
    private String Token;
    private String Instime;
    private WukongBean wukong;
    private String ExistDefaultCarModel;

    public String getMemberID() {
        return MemberID;
    }

    public void setMemberID(String MemberID) {
        this.MemberID = MemberID;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getInstime() {
        return Instime;
    }

    public void setInstime(String Instime) {
        this.Instime = Instime;
    }

    public WukongBean getWukong() {
        return wukong;
    }

    public void setWukong(WukongBean wukong) {
        this.wukong = wukong;
    }

    public String getExistDefaultCarModel() {
        return ExistDefaultCarModel;
    }

    public void setExistDefaultCarModel(String ExistDefaultCarModel) {
        this.ExistDefaultCarModel = ExistDefaultCarModel;
    }

    public static class WukongBean {
        /**
         * success : true
         * imSignModel : {"domain":"startest","appKey":"1da88a74d37bfd74800ff034cfcea384","nonce":"NHAEmT","timestamp":1491989212,"signature":"613ed225cd4b45541d59f377adf9b1cc8cb1d595ff811bb5c9afc27109191be1","openId":"79930"}
         */

        private boolean success;
        private ImSignModelBean imSignModel;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public ImSignModelBean getImSignModel() {
            return imSignModel;
        }

        public void setImSignModel(ImSignModelBean imSignModel) {
            this.imSignModel = imSignModel;
        }

        public static class ImSignModelBean {
            /**
             * domain : startest
             * appKey : 1da88a74d37bfd74800ff034cfcea384
             * nonce : NHAEmT
             * timestamp : 1491989212
             * signature : 613ed225cd4b45541d59f377adf9b1cc8cb1d595ff811bb5c9afc27109191be1
             * openId : 79930
             */

            private String domain;
            private String appKey;
            private String nonce;
            private int timestamp;
            private String signature;
            private String openId;

            public String getDomain() {
                return domain;
            }

            public void setDomain(String domain) {
                this.domain = domain;
            }

            public String getAppKey() {
                return appKey;
            }

            public void setAppKey(String appKey) {
                this.appKey = appKey;
            }

            public String getNonce() {
                return nonce;
            }

            public void setNonce(String nonce) {
                this.nonce = nonce;
            }

            public int getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(int timestamp) {
                this.timestamp = timestamp;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getOpenId() {
                return openId;
            }

            public void setOpenId(String openId) {
                this.openId = openId;
            }
        }
    }
}
