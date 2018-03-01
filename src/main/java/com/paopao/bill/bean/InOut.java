package com.paopao.bill.bean;

/**
 * @author luoxiaozhu
 * @date 2018-2-28-0028 18:10
 */
public class InOut {
    private String id;
    private String resultId;
    private String userId;
    private double in;
    private double out;

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

    public double getIn() {
        return in;
    }

    public void setIn(double in) {
        this.in = in;
    }

    public double getOut() {
        return out;
    }

    public void setOut(double out) {
        this.out = out;
    }
}
