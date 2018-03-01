package com.paopao.bill.bean;

/**
 * @author luoxiaozhu
 * @date 2018-2-28-0028 17:28
 */
public class Result {
    private String id;
    private int year;
    private int month;
    private double avg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}
