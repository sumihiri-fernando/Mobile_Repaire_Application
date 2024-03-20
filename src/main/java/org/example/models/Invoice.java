package org.example.models;

public class Invoice {
    private int invoiceId;
    private int customerId;
    private int deviceId;
    private int invoiceCreatedById;
    private int device_allocatedId;
    private int branchId;
    private String paymentmethod;
    private int repaireCost;
    private String issuedDate;
    private String deadline;
    private String statuses;

    public Invoice() {
    }

    public Invoice(int invoiceId, int customerId, int deviceId, int invoiceCreatedById, int device_allocatedId, int branchId, String paymentmethod, int repaireCost, String issuedDate, String deadline, String statuses) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.invoiceCreatedById = invoiceCreatedById;
        this.device_allocatedId = device_allocatedId;
        this.branchId = branchId;
        this.paymentmethod = paymentmethod;
        this.repaireCost = repaireCost;
        this.issuedDate = issuedDate;
        this.deadline = deadline;
        this.statuses = statuses;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public int getInvoiceCreatedById() {
        return invoiceCreatedById;
    }

    public int getDevice_allocatedId() {
        return device_allocatedId;
    }

    public int getBranchId() {
        return branchId;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public int getRepaireCost() {
        return repaireCost;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getStatuses() {
        return statuses;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public void setInvoiceCreatedById(int invoiceCreatedById) {
        this.invoiceCreatedById = invoiceCreatedById;
    }

    public void setDevice_allocatedId(int device_allocatedId) {
        this.device_allocatedId = device_allocatedId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public void setRepaireCost(int repaireCost) {
        this.repaireCost = repaireCost;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setStatuses(String statuses) {
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", customerId=" + customerId +
                ", deviceId=" + deviceId +
                ", invoiceCreatedById=" + invoiceCreatedById +
                ", device_allocatedId=" + device_allocatedId +
                ", branchId=" + branchId +
                ", paymentmethod='" + paymentmethod + '\'' +
                ", repaireCost=" + repaireCost +
                ", issuedDate='" + issuedDate + '\'' +
                ", deadline='" + deadline + '\'' +
                ", statuses='" + statuses + '\'' +
                '}';
    }
}
