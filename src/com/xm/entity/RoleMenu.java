package com.xm.entity;

/**
 * @author : 张晋飞
 * date : 2019/3/27
 */
public class RoleMenu {
    private int id;
    private int r_id;
    private int m_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public RoleMenu(int id, int r_id, int m_id) {
        this.id = id;
        this.r_id = r_id;
        this.m_id = m_id;
    }

    public RoleMenu() {
    }

    public RoleMenu(int r_id, int m_id) {
        this.r_id = r_id;
        this.m_id = m_id;
    }
}
