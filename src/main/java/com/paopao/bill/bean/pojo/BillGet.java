package com.paopao.bill.bean.pojo;

/**
 * @author luoxiaozhu
 * @date 2018-2-28-0028 17:25
 */

public class BillGet {
    private String id;

    private String userName;

    private double money;

    private String time;

    /** 0:未结算，1:已结算 */
    private int flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
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
}
