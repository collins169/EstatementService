package com.fasylgroup.engineering.EstatementDispatcher.Model;

import java.util.List;

public class TransactionHistory {
    private AllCustomerAccount AllCustomerAccount;
    private List<StvwTransaction> StvwTransactions;

    public AllCustomerAccount getAllCustomerAccount() {
        return AllCustomerAccount;
    }

    public void setAllCustomerAccount(AllCustomerAccount allCustomerAccount) {
        AllCustomerAccount = allCustomerAccount;
    }

    public List<StvwTransaction> getStvwTransactions() {
        return StvwTransactions;
    }

    public void setStvwTransactions(List<StvwTransaction> stvwTransactions) {
        StvwTransactions = stvwTransactions;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "AllCustomerAccount=" + AllCustomerAccount +
                ", StvwTransactions=" + StvwTransactions +
                '}';
    }
}
