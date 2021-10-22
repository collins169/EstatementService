package com.fasylgroup.engineering.EstatementDispatcher.Model;

public class AccountInfo {
    private String custAcNo;
    private String accountClass;

    public String getCustAcNo() {
        return custAcNo;
    }

    public void setCustAcNo(String custAcNo) {
        this.custAcNo = custAcNo;
    }

    public String getAccountClass() {
        return accountClass;
    }

    public void setAccountClass(String accountClass) {
        this.accountClass = accountClass;
    }

    @Override
    public String toString() {
        return "accountInfo{" +
                "custAcNo='" + custAcNo + '\'' +
                ", accountClass='" + accountClass + '\'' +
                '}';
    }
}
