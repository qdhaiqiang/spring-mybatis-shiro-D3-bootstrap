package com.eliteams.quick4j.web.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-2
 * Time: 下午1:53
 * To change this template use File | Settings | File Templates.
 */
public class Resale {
    private long id;
    private String name;
    private String phone;
    private String originLocation;
    private String resaleLocation;
    private String originPrice;
    private String resalePrice;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(String originLocation) {
        this.originLocation = originLocation;
    }

    public String getResaleLocation() {
        return resaleLocation;
    }

    public void setResaleLocation(String resaleLocation) {
        this.resaleLocation = resaleLocation;
    }

    public String getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(String originPrice) {
        this.originPrice = originPrice;
    }

    public String getResalePrice() {
        return resalePrice;
    }

    public void setResalePrice(String resalePrice) {
        this.resalePrice = resalePrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
