package com.example.retretku.Object;

public class Report {
    private String reportBy, reportText, date;
    private int status;

    public Report(String reportBy, String reportText, String date, int status) {
        this.reportBy = reportBy;
        this.reportText = reportText;
        this.date = date;
        this.status = status;
    }

    public String getReportBy() {
        return reportBy;
    }

    public void setReportBy(String reportBy) {
        this.reportBy = reportBy;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
