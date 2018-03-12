package com.paopao.bill.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luoxiaozhu
 * @date 2018-2-28-0028 18:10
 */
@Entity
@Table(name = "inoutmoney")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class InOut {
    @Id
    private String id;

    @Column(name = "resultId")
    private String resultId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "inMoney")
    private double inMoney;

    @Column(name = "outMoney")
    private double outMoney;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getInMoney() {
        return inMoney;
    }

    public void setInMoney(double inMoney) {
        this.inMoney = inMoney;
    }

    public double getOutMoney() {
        return outMoney;
    }

    public void setOutMoney(double outMoney) {
        this.outMoney = outMoney;
    }
}
