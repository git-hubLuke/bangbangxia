package com.example.bangbangxia.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_phone;
    private String user_email;//邮箱
    private String user_token;//记录登陆标记的token
    private Timestamp user_createtime;//创建时间

    private String user_nickname;//微信昵称
    private String user_headpic;//头像的url
//    @JsonProperty("sex")
    private String user_sex;//性别：1表示男，0表示女
//    @JsonProperty("city")
    private String user_city;
//    @JsonProperty("openid")
    private String user_openid;//微信开放平台id
//    @JsonProperty("province")
    private String user_province;//省份
//    @JsonProperty("country")
    private String user_county;//国家

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    public Timestamp getUser_createtime() {
        return user_createtime;
    }

    public void setUser_createtime(Timestamp user_createtime) {
        this.user_createtime = user_createtime;
    }

    @JSONField(name="nickname")
    public String getUser_nickname() {
        return user_nickname;
    }
    @JSONField(name="nickname")
    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }
    @JSONField(name="headimgurl")
    public String getUser_headpic() {
        return user_headpic;
    }
    @JSONField(name="headimgurl")
    public void setUser_headpic(String user_headpic) {
        this.user_headpic = user_headpic;
    }
    @JSONField(name="sex")
    public String getUser_sex() {
        return user_sex;
    }
    @JSONField(name="sex")
    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }
    @JSONField(name="city")
    public String getUser_city() {
        return user_city;
    }
    @JSONField(name="city")
    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }
    @JSONField(name="openid")
    public String getUser_openid() {
        return user_openid;
    }
    @JSONField(name="openid")
    public void setUser_openid(String user_openid) {
        this.user_openid = user_openid;
    }
    @JSONField(name="province")
    public String getUser_province() {
        return user_province;
    }
    @JSONField(name="province")
    public void setUser_province(String user_province) {
        this.user_province = user_province;
    }
    @JSONField(name="country")
    public String getUser_county() {
        return user_county;
    }
    @JSONField(name="country")
    public void setUser_county(String user_county) {
        this.user_county = user_county;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_token='" + user_token + '\'' +
                ", user_createtime=" + user_createtime +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_headpic='" + user_headpic + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_city='" + user_city + '\'' +
                ", user_openid='" + user_openid + '\'' +
                ", user_province='" + user_province + '\'' +
                ", user_county='" + user_county + '\'' +
                '}';
    }
}
