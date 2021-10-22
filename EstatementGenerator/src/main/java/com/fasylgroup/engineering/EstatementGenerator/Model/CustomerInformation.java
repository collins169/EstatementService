package com.fasylgroup.engineering.EstatementGenerator.Model;

public class CustomerInformation {
    private int position;
    private String CustomerName;
    private String Ccy;
    private String Description;
    private double AcyOpeningBal;
    private double AcyAvlbal;
    private String CustAcNo;
    private String CustNo;
    private String BranchCode;
    private String BranchName;
    private String BranchAddr1;
    private String Address2;
    private double AcyTodayToverDr;
    private double AcyTodayToverCr;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCcy() {
        return Ccy;
    }

    public void setCcy(String ccy) {
        Ccy = ccy;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getAcyOpeningBal() {
        return AcyOpeningBal;
    }

    public void setAcyOpeningBal(double acyOpeningBal) {
        AcyOpeningBal = acyOpeningBal;
    }

    public double getAcyAvlbal() {
        return AcyAvlbal;
    }

    public void setAcyAvlbal(double acyAvlbal) {
        AcyAvlbal = acyAvlbal;
    }

    public String getCustAcNo() {
        return CustAcNo;
    }

    public void setCustAcNo(String custAcNo) {
        CustAcNo = custAcNo;
    }

    public String getCustNo() {
        return CustNo;
    }

    public void setCustNo(String custNo) {
        CustNo = custNo;
    }

    public String getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(String branchCode) {
        BranchCode = branchCode;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getBranchAddr1() {
        return BranchAddr1;
    }

    public void setBranchAddr1(String branchAddr1) {
        BranchAddr1 = branchAddr1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public double getAcyTodayToverDr() {
        return AcyTodayToverDr;
    }

    public void setAcyTodayToverDr(double acyTodayToverDr) {
        AcyTodayToverDr = acyTodayToverDr;
    }

    public double getAcyTodayToverCr() {
        return AcyTodayToverCr;
    }

    public void setAcyTodayToverCr(double acyTodayToverCr) {
        AcyTodayToverCr = acyTodayToverCr;
    }

    @Override
    public String toString() {
        return "CustomerInformation{" +
                "position=" + position +
                ", CustomerName='" + CustomerName + '\'' +
                ", Ccy='" + Ccy + '\'' +
                ", Description='" + Description + '\'' +
                ", AcyOpeningBal=" + AcyOpeningBal +
                ", AcyAvlbal=" + AcyAvlbal +
                ", CustAcNo='" + CustAcNo + '\'' +
                ", CustNo='" + CustNo + '\'' +
                ", BranchCode='" + BranchCode + '\'' +
                ", BranchName='" + BranchName + '\'' +
                ", BranchAddr1='" + BranchAddr1 + '\'' +
                ", Address2='" + Address2 + '\'' +
                ", AcyTodayToverDr=" + AcyTodayToverDr +
                ", AcyTodayToverCr=" + AcyTodayToverCr +
                '}';
    }
}
