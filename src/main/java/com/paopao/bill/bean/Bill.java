package com.paopao.bill.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luoxiaozhu
 * @date 2018-2-28-0028 17:25
 */
@Entity
@Table(name = "bill")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Bill {
    @Id
    private String id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "money")
    private double money;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private String time;

    /** 0:未结算，1:已结算 */
    @Column(name = "flag")
    private int flag;

    @Column(name = "flagTime")
    private String flagTime;

    @Column(name = "submitTime")
    private String submitTime;

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getFlagTime() {
        return flagTime;
    }

    public void setFlagTime(String flagTime) {
        this.flagTime = flagTime;
    }
}
