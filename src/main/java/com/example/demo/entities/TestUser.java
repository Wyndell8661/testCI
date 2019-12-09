package com.example.demo.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;


public class TestUser {

    private Long userId;

    @NotNull
    @Size(min = 6,max =20,message = "用户名长度错误 ")
    private String userName;

    @NotNull
    @Size(min = 8,max = 16,message = "密码长度不合规范 ")
    private String passWord;

    @NotNull
    @Pattern(regexp = "^admin$|^用户管理员$|^普通用户$",message = "name必须为admin/用户管理员/普通用户")
    private String name;

    @NotNull
    private String jobNumber;

    @Pattern(regexp = "1[3|4|5|7|8][0-9]\\d{8}", message = "手机号码格式错误 ")
    private String mobile;

    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "邮箱格式错误 ")
    private String email;

    @NotNull
    private Date lastLoginTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", name='" + name + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
