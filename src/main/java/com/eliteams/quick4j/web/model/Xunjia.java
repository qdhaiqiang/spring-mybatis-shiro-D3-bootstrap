package com.eliteams.quick4j.web.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-2
 * Time: 下午6:34
 * To change this template use File | Settings | File Templates.
 */
public class Xunjia {
    private long xunJiaId;
    private long beiXunjiaId;
    private String xunJiaName;
    private String beiXunjiaName;
    private Date date;

    public long getXunJiaId() {
        return xunJiaId;
    }

    public void setXunJiaId(long xunJiaId) {
        this.xunJiaId = xunJiaId;
    }

    public long getBeiXunjiaId() {
        return beiXunjiaId;
    }

    public void setBeiXunjiaId(long beiXunjiaId) {
        this.beiXunjiaId = beiXunjiaId;
    }

    public String getXunJiaName() {
        return xunJiaName;
    }

    public void setXunJiaName(String xunJiaName) {
        this.xunJiaName = xunJiaName;
    }

    public String getBeiXunjiaName() {
        return beiXunjiaName;
    }

    public void setBeiXunjiaName(String beiXunjiaName) {
        this.beiXunjiaName = beiXunjiaName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
