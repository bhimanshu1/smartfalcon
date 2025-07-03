package org.example;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType()
public class Asset {

    @Property()
    private String dealerId;

    @Property()
    private String msisdn;

    @Property()
    private String mpin;

    @Property()
    private double balance;

    @Property()
    private String status;

    @Property()
    private double transAmount;

    @Property()
    private String transType;

    @Property()
    private String remarks;

    // Constructor
    public Asset() {
    }

    public Asset(String dealerId, String msisdn, String mpin, double balance,
                 String status, double transAmount, String transType, String remarks) {
        this.dealerId = dealerId;
        this.msisdn = msisdn;
        this.mpin = mpin;
        this.balance = balance;
        this.status = status;
        this.transAmount = transAmount;
        this.transType = transType;
        this.remarks = remarks;
    }

    // Getters and Setters

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMpin() {
        return mpin;
    }

    public void setMpin(String mpin) {
        this.mpin = mpin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



   
}