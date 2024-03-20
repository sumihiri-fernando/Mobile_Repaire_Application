package org.example.models;

public class Customers {

    private int customerId;
    private String customerName;
    private String customerEmail;
    private int customerContactno;
    private String customerAddress;

    public Customers() {
    }

    public Customers(int customerId, String customerName, String customerEmail, int customerContactno, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerContactno = customerContactno;
        this.customerAddress = customerAddress;

    }
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getCustomerContactno() {
        return customerContactno;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerContactno(int customerContactno) {
        this.customerContactno = customerContactno;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerContactno='" + customerContactno + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}

