package com.fasylgroup.engineering.EstatementDispatcher.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity
@Table(name = "STVW_TRANSACTIONS2")
public class StvwTransaction {
    @Id
    @Column(name = "AC_ENTRY_SR_NO")
    private Long acEntrySrNo;
    @Column(name = "TRN_REF_NO")
    private String trnRefNo;
    @Column(name = "AC_NO")
    private String acNo;
    @Column(name = "AC_CCY")
    private String acCcy;
    @Column(name = "DRCR_IND")
    private String drcrInd;
    @Column(name = "NARRATION")
    private String narration;
    @Null
    @Column(name = "FCY_AMOUNT", nullable = true)
    private double fcyAmount;
    @Column(name = "LCY_AMOUNT")
    private double lcyAmount;
    @Column(name = "TRN_DT")
    private Date trnDt;
    @Column(name = "VALUE_DT")
    private Date valueDt;
    @Column(name = "INSTRUMENT_CODE")
    private String instrumentCode;
    @Column(name = "AC_DESC")
    private String acDesc;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ACY_OPENING_BAL")
    private double acyOpeningBal;
    @Column(name = "DEBIT", nullable = true)
    private String debit;
    @Column(name = "CREDIT", nullable = true)
    private String credit;
    @Column(name = "RUNNINGBAL")
    private double runningbal;
    @Column(name = "AMOUNT")
    private double amount;

    public Long getAcEntrySrNo() {
        return acEntrySrNo;
    }

    public void setAcEntrySrNo(Long acEntrySrNo) {
        this.acEntrySrNo = acEntrySrNo;
    }

    public String getTrnRefNo() {
        return trnRefNo;
    }

    public void setTrnRefNo(String trnRefNo) {
        this.trnRefNo = trnRefNo;
    }

    public String getAcNo() {
        return acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public String getAcCcy() {
        return acCcy;
    }

    public void setAcCcy(String acCcy) {
        this.acCcy = acCcy;
    }

    public String getDrCrInd() {
        return drcrInd;
    }

    public void setDrCrInd(String drCrInd) {
        this.drcrInd = drCrInd;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public double getFcyAmount() {
        return fcyAmount;
    }

    public void setFcyAmount(double fcyAmount) {
        this.fcyAmount = fcyAmount;
    }

    public double getLcyAmount() {
        return lcyAmount;
    }

    public void setLcyAmount(double lcyAmount) {
        this.lcyAmount = lcyAmount;
    }

    public Date getTrnDt() {
        return trnDt;
    }

    public void setTrnDt(Date trnDt) {
        this.trnDt = trnDt;
    }

    public Date getValueDt() {
        return valueDt;
    }

    public void setValueDt(Date valueDt) {
        this.valueDt = valueDt;
    }

    public String getInstrumentCode() {
        return instrumentCode;
    }

    public void setInstrumentCode(String instrumentCode) {
        this.instrumentCode = instrumentCode;
    }

    public String getAcDesc() {
        return acDesc;
    }

    public void setAcDesc(String acDesc) {
        this.acDesc = acDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAcyOpeningBal() {
        return acyOpeningBal;
    }

    public void setAcyOpeningBal(double acyOpeningBal) {
        this.acyOpeningBal = acyOpeningBal;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public double getRunningBal() {
        return runningbal;
    }

    public void setRunningBal(double runningBal) {
        this.runningbal = runningBal;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "StvwTransaction{" +
                "acEntrySrNo='" + acEntrySrNo + '\'' +
                ", trnRefNo='" + trnRefNo + '\'' +
                ", acNo='" + acNo + '\'' +
                ", acCcy='" + acCcy + '\'' +
                ", drCrInd='" + drcrInd + '\'' +
                ", narration='" + narration + '\'' +
                ", fcyAmount=" + fcyAmount +
                ", lcyAmount=" + lcyAmount +
                ", trnDt=" + trnDt +
                ", valueDt=" + valueDt +
                ", instrumentCode='" + instrumentCode + '\'' +
                ", acDesc='" + acDesc + '\'' +
                ", description='" + description + '\'' +
                ", acyOpeningBal=" + acyOpeningBal +
                ", debit='" + debit + '\'' +
                ", credit='" + credit + '\'' +
                ", runningBal='" + runningbal + '\'' +
                ", amount=" + amount +
                '}';
    }
}
