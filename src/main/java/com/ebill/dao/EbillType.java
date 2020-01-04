package com.ebill.dao;

public class EbillType {

    private String id;
    private double busDataTime;
    private int value;

    public EbillType(String id, double busDataTime, int value) {
        this.id = id;
        this.busDataTime = busDataTime;
        this.value = value;
    }

    public EbillType() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBusDataTime() {
        return busDataTime;
    }

    public void setBusDataTime(double busDataTime) {
        this.busDataTime = busDataTime;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
