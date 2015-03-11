package com.eliteams.quick4j.core.entity;

/**
 * 菜单实体.
 * User: Administrator
 * Date: 15-3-9
 * Time: 下午1:43
 * To change this template use File | Settings | File Templates.
 */
public class MenuModel {
    private String title;
    private String url;
    private boolean isActive;   //菜单是否激活
    private boolean isAllow; //当前用户是否有权限点击

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isAllow() {
        return isAllow;
    }

    public void setAllow(boolean allow) {
        isAllow = allow;
    }
}
