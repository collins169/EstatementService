package com.fasylgroup.engineering.EstatementDispatcher.Model;

public class AllCustomerAccount {
    private int position;
    private String CustAcNo;
    private double AcyAvlBal;
    private String AcDesc;
    private String CcyName;
    private String Description;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getCustAcNo() {
        return CustAcNo;
    }

    public void setCustAcNo(String custAcNo) {
        CustAcNo = custAcNo;
    }

    public double getAcyAvlBal() {
        return AcyAvlBal;
    }

    public void setAcyAvlBal(double acyAvlBal) {
        AcyAvlBal = acyAvlBal;
    }

    public String getAcDesc() {
        return AcDesc;
    }

    public void setAcDesc(String acDesc) {
        AcDesc = acDesc;
    }

    public String getCcyName() {
        return CcyName;
    }

    public void setCcyName(String ccyName) {
        CcyName = ccyName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "AllCustomerAccount{" +
                "position=" + position +
                ", CustAcNo='" + CustAcNo + '\'' +
                ", AcyAvlBal=" + AcyAvlBal +
                ", AcDesc='" + AcDesc + '\'' +
                ", CcyName='" + CcyName + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
