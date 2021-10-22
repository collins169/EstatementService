package com.fasylgroup.engineering.EstatementDispatcher.Model;

public class TransactionStatistics {
    private int TotalNumOfTransaction;
    private double TotalCredits;
    private double TotalDebits;
    private int TotalAtmTransaction;
    private double TotalAtmCredits;
    private double TotalAtmDebits;
    private double TotalAtmPercent;
    private int TotalPosTransaction;
    private double TotalPosCredits;
    private double TotalPosDebits;
    private double TotalPosPercent;
    private int OthersTotalTransaction;
    private double OthersTotalCredits;
    private double OthersTotalDebits;
    private double OthersTotalPercent;

    public int getTotalNumOfTransaction() {
        return TotalNumOfTransaction;
    }

    public void setTotalNumOfTransaction(int totalNumOfTransaction) {
        TotalNumOfTransaction = totalNumOfTransaction;
    }

    public double getTotalCredits() {
        return TotalCredits;
    }

    public void setTotalCredits(double totalCredits) {
        TotalCredits = totalCredits;
    }

    public double getTotalDebits() {
        return TotalDebits;
    }

    public void setTotalDebits(double totalDebits) {
        TotalDebits = totalDebits;
    }

    public int getTotalAtmTransaction() {
        return TotalAtmTransaction;
    }

    public void setTotalAtmTransaction(int totalAtmTransaction) {
        TotalAtmTransaction = totalAtmTransaction;
    }

    public double getTotalAtmCredits() {
        return TotalAtmCredits;
    }

    public void setTotalAtmCredits(double totalAtmCredits) {
        TotalAtmCredits = totalAtmCredits;
    }

    public double getTotalAtmDebits() {
        return TotalAtmDebits;
    }

    public void setTotalAtmDebits(double totalAtmDebits) {
        TotalAtmDebits = totalAtmDebits;
    }

    public double getTotalAtmPercent() {
        return TotalAtmPercent;
    }

    public void setTotalAtmPercent(double totalAtmPercent) {
        TotalAtmPercent = totalAtmPercent;
    }

    public int getTotalPosTransaction() {
        return TotalPosTransaction;
    }

    public void setTotalPosTransaction(int totalPosTransaction) {
        TotalPosTransaction = totalPosTransaction;
    }

    public double getTotalPosCredits() {
        return TotalPosCredits;
    }

    public void setTotalPosCredits(double totalPosCredits) {
        TotalPosCredits = totalPosCredits;
    }

    public double getTotalPosDebits() {
        return TotalPosDebits;
    }

    public void setTotalPosDebits(double totalPosDebits) {
        TotalPosDebits = totalPosDebits;
    }

    public double getTotalPosPercent() {
        return TotalPosPercent;
    }

    public void setTotalPosPercent(double totalPosPercent) {
        TotalPosPercent = totalPosPercent;
    }

    public int getOthersTotalTransaction() {
        return OthersTotalTransaction;
    }

    public void setOthersTotalTransaction(int othersTotalTransaction) {
        OthersTotalTransaction = othersTotalTransaction;
    }

    public double getOthersTotalCredits() {
        return OthersTotalCredits;
    }

    public void setOthersTotalCredits(double othersTotalCredits) {
        OthersTotalCredits = othersTotalCredits;
    }

    public double getOthersTotalDebits() {
        return OthersTotalDebits;
    }

    public void setOthersTotalDebits(double othersTotalDebits) {
        OthersTotalDebits = othersTotalDebits;
    }

    public double getOthersTotalPercent() {
        return OthersTotalPercent;
    }

    public void setOthersTotalPercent(double othersTotalPercent) {
        OthersTotalPercent = othersTotalPercent;
    }

    @Override
    public String toString() {
        return "TransactionStatistics{" +
                "TotalNumOfTransaction=" + TotalNumOfTransaction +
                ", TotalCredits=" + TotalCredits +
                ", TotalDebits=" + TotalDebits +
                ", TotalAtmTransaction=" + TotalAtmTransaction +
                ", TotalAtmCredits=" + TotalAtmCredits +
                ", TotalAtmDebits=" + TotalAtmDebits +
                ", TotalAtmPercent=" + TotalAtmPercent +
                ", TotalPosTransaction=" + TotalPosTransaction +
                ", TotalPosCredits=" + TotalPosCredits +
                ", TotalPosDebits=" + TotalPosDebits +
                ", TotalPosPercent=" + TotalPosPercent +
                ", OthersTotalTransaction=" + OthersTotalTransaction +
                ", OthersTotalCredits=" + OthersTotalCredits +
                ", OthersTotalDebits=" + OthersTotalDebits +
                ", OthersTotalPercent=" + OthersTotalPercent +
                '}';
    }
}
