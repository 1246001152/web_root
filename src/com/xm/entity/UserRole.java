package com.xm.entity;

/**
 * @author : 张晋飞
 * date : 2019/3/27
 */
public class UserRole {

    private int id;
    private int u_id;
    private int r_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public UserRole(int u_id, int r_id) {
        this.u_id = u_id;
        this.r_id = r_id;
    }

    public UserRole() {
    }

    public UserRole(int id, int u_id, int r_id) {
        this.id = id;
        this.u_id = u_id;
        this.r_id = r_id;
    }
}
