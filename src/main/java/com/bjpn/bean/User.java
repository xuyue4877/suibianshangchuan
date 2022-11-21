package com.bjpn.bean;

import java.util.Objects;

public class User {
    private int userId;
    private String userName;
    private String userCode;
    private String userPwd;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userCode, user.userCode) &&
                Objects.equals(userPwd, user.userPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userCode, userPwd);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }

    public User(int userId, String userName, String userCode, String userPwd) {
        this.userId = userId;
        this.userName = userName;
        this.userCode = userCode;
        this.userPwd = userPwd;
    }
    public User(){}
}
