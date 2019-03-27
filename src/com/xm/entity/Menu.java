package com.xm.entity;

/**
 * @author : 张晋飞
 * date : 2019/3/27
 */
public class Menu {


    private int mId;
    private int pId = -1;
    private String menuName;
    private String  url = "javascript:;";
    private String  img ;

    public Menu(int mId, int pId, String menuName, String url) {
        this.mId = mId;
        this.pId = pId;
        this.menuName = menuName;
        this.url = url;
    }

    public Menu(int pId, String menuName, String url) {
        this.pId = pId;
        this.menuName = menuName;
        this.url = url;
    }

    public Menu() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
