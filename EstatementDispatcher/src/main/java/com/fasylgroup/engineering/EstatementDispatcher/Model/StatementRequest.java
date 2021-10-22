package com.fasylgroup.engineering.EstatementDispatcher.Model;

import java.util.List;

public class StatementRequest {
    private String CustId;
    private SttbScheduledStatements SttbScheduledStatements;
    private List<CustomerInformation> CustomerInformations;
    private List<AllCustomerAccount> AllCustomerAccounts;
    private List<StvwTransaction> StvwTransactions;
    private List<TransactionHistory> TransactionHistories;
    private TransactionStatistics TransactionStatistics;

    public String getCustId() {
        return CustId;
    }

    public void setCustId(String custId) {
        CustId = custId;
    }

    public com.fasylgroup.engineering.EstatementDispatcher.Model.SttbScheduledStatements getSttbScheduledStatements() {
        return SttbScheduledStatements;
    }

    public void setSttbScheduledStatements(com.fasylgroup.engineering.EstatementDispatcher.Model.SttbScheduledStatements sttbScheduledStatements) {
        SttbScheduledStatements = sttbScheduledStatements;
    }

    public List<CustomerInformation> getCustomerInformations() {
        return CustomerInformations;
    }

    public void setCustomerInformations(List<CustomerInformation> customerInformations) {
        CustomerInformations = customerInformations;
    }

    public List<AllCustomerAccount> getAllCustomerAccounts() {
        return AllCustomerAccounts;
    }

    public void setAllCustomerAccounts(List<AllCustomerAccount> allCustomerAccounts) {
        AllCustomerAccounts = allCustomerAccounts;
    }

    public List<StvwTransaction> getStvwTransactions() {
        return StvwTransactions;
    }

    public void setStvwTransactions(List<StvwTransaction> stvwTransactions) {
        StvwTransactions = stvwTransactions;
    }

    public List<TransactionHistory> getTransactionHistories() {
        return TransactionHistories;
    }

    public void setTransactionHistories(List<TransactionHistory> transactionHistories) {
        TransactionHistories = transactionHistories;
    }

    public com.fasylgroup.engineering.EstatementDispatcher.Model.TransactionStatistics getTransactionStatistics() {
        return TransactionStatistics;
    }

    public void setTransactionStatistics(com.fasylgroup.engineering.EstatementDispatcher.Model.TransactionStatistics transactionStatistics) {
        TransactionStatistics = transactionStatistics;
    }

    @Override
    public String toString() {
        return "StatementRequest{" +
                "CustId='" + CustId + '\'' +
                ", SttbScheduledStatements=" + SttbScheduledStatements +
                ", CustomerInformations=" + CustomerInformations +
                ", AllCustomerAccounts=" + AllCustomerAccounts +
                ", StvwTransactions=" + StvwTransactions +
                ", TransactionHistories=" + TransactionHistories +
                ", TransactionStatistics=" + TransactionStatistics +
                '}';
    }
}
