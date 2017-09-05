package wen.xiao.com.simpleproject.entity;

/**
 * Created by Administrator on 2017/5/17.
 */

public class loging {

    /**
     * msg : 请求成功
     * code : 12000
     * data : {"gender":0,"isbindPhone":1,"city":"中国","nickName":"花韩96807","huanxinPwd":"123456","huanxinId":"qffuyhyctagkekvasnxyrisrynfu","cityId":1,"provinceId":1,"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjc4MTgsInRpbWUiOjE0OTUwOTA1MDJ9._pzIPVV-Xyi9vY3EHxZQu3v6zPadiqSNPBWIHfhJ8Wk","huahanhxId":"bmrjvzzjfplmpbucoapdcmhlxipk","province":"中国","CustomerTel":"021-34696288","intro":"","id":7818,"userType":1,"ageId":903,"account":"18521596791","age":"20-25岁","headimgUrl":"http://pic.huakr.com/default/huahan_personal.jpg"}
     */

    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * gender : 0
         * isbindPhone : 1
         * city : 中国
         * nickName : 花韩96807
         * huanxinPwd : 123456
         * huanxinId : qffuyhyctagkekvasnxyrisrynfu
         * cityId : 1
         * provinceId : 1
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjc4MTgsInRpbWUiOjE0OTUwOTA1MDJ9._pzIPVV-Xyi9vY3EHxZQu3v6zPadiqSNPBWIHfhJ8Wk
         * huahanhxId : bmrjvzzjfplmpbucoapdcmhlxipk
         * province : 中国
         * CustomerTel : 021-34696288
         * intro :
         * id : 7818
         * userType : 1
         * ageId : 903
         * account : 18521596791
         * age : 20-25岁
         * headimgUrl : http://pic.huakr.com/default/huahan_personal.jpg
         */

        private int gender;
        private int isbindPhone;
        private String city;
        private String nickName;
        private String huanxinPwd;
        private String huanxinId;
        private int cityId;
        private int provinceId;
        private String token;
        private String huahanhxId;
        private String province;
        private String CustomerTel;
        private String intro;
        private int id;
        private int userType;
        private int ageId;
        private String account;
        private String age;
        private String headimgUrl;

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getIsbindPhone() {
            return isbindPhone;
        }

        public void setIsbindPhone(int isbindPhone) {
            this.isbindPhone = isbindPhone;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getHuanxinPwd() {
            return huanxinPwd;
        }

        public void setHuanxinPwd(String huanxinPwd) {
            this.huanxinPwd = huanxinPwd;
        }

        public String getHuanxinId() {
            return huanxinId;
        }

        public void setHuanxinId(String huanxinId) {
            this.huanxinId = huanxinId;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public int getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getHuahanhxId() {
            return huahanhxId;
        }

        public void setHuahanhxId(String huahanhxId) {
            this.huahanhxId = huahanhxId;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCustomerTel() {
            return CustomerTel;
        }

        public void setCustomerTel(String CustomerTel) {
            this.CustomerTel = CustomerTel;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getAgeId() {
            return ageId;
        }

        public void setAgeId(int ageId) {
            this.ageId = ageId;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getHeadimgUrl() {
            return headimgUrl;
        }

        public void setHeadimgUrl(String headimgUrl) {
            this.headimgUrl = headimgUrl;
        }
    }
}
