package com.eliteams.quick4j.web.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-6
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 */
public class FriendsWithPhone {
    private long id;
    private String name;
    private String phone;
    private long middleId;
    private String middleName;
    private String middlePhone;
    private long secondId;
    private String secondName;
    private String secondPhone;
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

    public long getMiddleId() {
        return middleId;
    }

    public void setMiddleId(long middleId) {
        this.middleId = middleId;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddlePhone() {
        return middlePhone;
    }

    public void setMiddlePhone(String middlePhone) {
        this.middlePhone = middlePhone;
    }

    public long getSecondId() {
        return secondId;
    }

    public void setSecondId(long secondId) {
        this.secondId = secondId;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
