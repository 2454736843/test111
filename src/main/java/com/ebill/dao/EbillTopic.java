package com.ebill.dao;

public class EbillTopic {

    private String busNo;
    private String placeCode;
    private String systemcode;
    private double busDateTime;
    private String payer;
    private String patientId;
    private String sex;
    private String tel;
    private String age;

    public EbillTopic(String busNo, String placeCode, String systemcode, double busDateTime, String payer, String patientId, String sex, String tel, String age) {
        this.busNo = busNo;
        this.placeCode = placeCode;
        this.systemcode = systemcode;
        this.busDateTime = busDateTime;
        this.payer = payer;
        this.patientId = patientId;
        this.sex = sex;
        this.tel = tel;
        this.age = age;
    }

    public EbillTopic() {
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    public String getSystemcode() {
        return systemcode;
    }

    public void setSystemcode(String systemcode) {
        this.systemcode = systemcode;
    }

    public double getBusDateTime() {
        return busDateTime;
    }

    public void setBusDateTime(double busDateTime) {
        this.busDateTime = busDateTime;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
