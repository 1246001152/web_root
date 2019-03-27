package com.xm.entity;

/**
 * @author : 张晋飞
 * date : 2019/3/27
 */
public class User {


    private int uId;
    private String  username;
    private String  password;
    private String  roleName;

    public User(int uId, String username, String password) {
        this.uId = uId;
        this.username = username;
        this.password = password;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
