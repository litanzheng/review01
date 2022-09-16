package com.tencent.internet.qq.qqclient.qqcommon;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String password;

    private static final long serialVersionUid= 1L;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
