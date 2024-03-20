package org.example.models;

public class MobileDevice {
    private int mobileDeviceId;
    private int customerId;
    private String model;
    private String serialNo;
    private String brand;

    public MobileDevice() {
    }

    public MobileDevice(int mobileDeviceId, int customerId, String model, String serialNo, String customerMobileImage) {
        this.mobileDeviceId = mobileDeviceId;
        this.customerId = customerId;
        this.model = model;
        this.serialNo = serialNo;
        this.brand = customerMobileImage;
    }

    public int getMobileDeviceId() {
        return mobileDeviceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setMobileDeviceId(int mobileDeviceId) {
        this.mobileDeviceId = mobileDeviceId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "MobileDevice{" +
                "mobileDeviceId=" + mobileDeviceId +
                ", customerId=" + customerId +
                ", model='" + model + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", customerMobileImage='" + brand + '\'' +
                '}';
    }

}
