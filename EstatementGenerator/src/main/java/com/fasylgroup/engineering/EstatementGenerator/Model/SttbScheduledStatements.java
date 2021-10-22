package com.fasylgroup.engineering.EstatementGenerator.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "STTB_SCHEDULED_STATMENTS_DEV")
public class SttbScheduledStatements {
    @Id
    @Column(name = "GUID")
    private String guid;
    @Column(name = "CUST_NO")
    private String custNo;
    @Column(name = "AC_NO")
    private String acNo;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "STMNT_TYPE")
    private String stmntType;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "SCHEDULE_STAMP")
    private Date scheduleStamp;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "STMT_PASS")
    private String stmtPass;
    @Column(name = "STMT_DT_SEND")
    private Date stmtDtSend;
    @Column(name = "PDF_PATH")
    private String pdfPath;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getAcNo() {
        return acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStmntType() {
        return stmntType;
    }

    public void setStmntType(String stmntType) {
        this.stmntType = stmntType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getScheduleStamp() {
        return scheduleStamp;
    }

    public void setScheduleStamp(Date scheduleStamp) {
        this.scheduleStamp = scheduleStamp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStmtPass() {
        return stmtPass;
    }

    public void setStmtPass(String stmtPass) {
        this.stmtPass = stmtPass;
    }

    public Date getStmtDtSend() {
        return stmtDtSend;
    }

    public void setStmtDtSend(Date stmtDtSend) {
        this.stmtDtSend = stmtDtSend;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    @Override
    public String toString() {
        return "SttbScheduledStatements{" +
                "guid='" + guid + '\'' +
                ", custNo='" + custNo + '\'' +
                ", acNo='" + acNo + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", stmntType='" + stmntType + '\'' +
                ", status='" + status + '\'' +
                ", scheduleStamp=" + scheduleStamp +
                ", email='" + email + '\'' +
                ", stmtPass='" + stmtPass + '\'' +
                ", stmtDtSend=" + stmtDtSend +
                ", pdfPath='" + pdfPath + '\'' +
                '}';
    }
}
