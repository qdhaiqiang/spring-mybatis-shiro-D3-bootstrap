package com.eliteams.quick4j.web.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-9
 * Time: 下午3:19
 * To change this template use File | Settings | File Templates.
 */
public class Invite {
    private long id;
    private long invitedId;
    private String name;
    private String invitedName;
    private String phone;
    private String invitedPhone;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInvitedId() {
        return invitedId;
    }

    public void setInvitedId(long invitedId) {
        this.invitedId = invitedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInvitedName() {
        return invitedName;
    }

    public void setInvitedName(String invitedName) {
        this.invitedName = invitedName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInvitedPhone() {
        return invitedPhone;
    }

    public void setInvitedPhone(String invitedPhone) {
        this.invitedPhone = invitedPhone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
