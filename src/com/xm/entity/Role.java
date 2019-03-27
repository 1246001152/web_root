package com.xm.entity;

/**
 * @author : 张晋飞
 * date : 2019/3/27
 */
public class Role {


    private int r_id;
    private String role_name;

    public Role(int r_id, String role_name) {
        this.r_id = r_id;
        this.role_name = role_name;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Role(String role_name) {
        this.role_name = role_name;
    }

    public Role() {
    }
}
