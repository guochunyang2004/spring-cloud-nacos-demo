package cn.zipworld.cloud.common.entity.auth;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserContext implements Serializable {
    private Long id;
    private String loginName;//登录名
    private String name;  //姓名
    private Integer appId;
    private String mobile;
    private Integer sex;
    private String token;
    private String OpenId;
    private LocalDateTime expire;
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    public Integer getSex() {
//        return sex;
//    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}