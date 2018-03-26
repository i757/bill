package com.paopao.bill.bean.pojo;

import java.util.List;

public class ResultBean {

    private double avg;

    private String resultTime;

    private List<InOutBean> list;

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getResultTime() {
        return resultTime;
    }

    public void setResultTime(String resultTime) {
        this.resultTime = resultTime;
    }

    public List<InOutBean> getList() {
        return list;
    }

    public void setList(List<InOutBean> list) {
        this.list = list;
    }
}
