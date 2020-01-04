package com.ebill.dao;

public class EbillDetail {
    private String id;
    private String e_name;
    private String male;
    private String e_location;
    private String e_type;
    private double busDataTime;

    public EbillDetail(String id, String e_name, String male, String e_location, String e_type, double busDataTime) {
        this.id = id;
        this.e_name = e_name;
        this.male = male;
        this.e_location = e_location;
        this.e_type = e_type;
        this.busDataTime = busDataTime;
    }

    public EbillDetail() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getE_location() {
        return e_location;
    }

    public void setE_location(String e_location) {
        this.e_location = e_location;
    }

    public String getE_type() {
        return e_type;
    }

    public void setE_type(String e_type) {
        this.e_type = e_type;
    }

    public double getBusDataTime() {
        return busDataTime;
    }

    public void setBusDataTime(double busDataTime) {
        this.busDataTime = busDataTime;
    }
}

