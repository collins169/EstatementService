package com.fasylgroup.engineering.EstatementDispatcher.Model;

public class CustomerInfo {
    private String custNo;
    private String custName;
    private String custEmail;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "custNo='" + custNo + '\'' +
                ", custName='" + custName + '\'' +
                ", custEmail='" + custEmail + '\'' +
                '}';
    }
}
