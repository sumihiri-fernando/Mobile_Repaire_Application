package org.example.models;

public class Branch {

    private int branchId;
    private String branchName;
    private int phoneno;
    private String email;
    private String address;

    public Branch() {
    }

    public Branch(int branchId, String branchName, int phoneno, String email, String address) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.phoneno = phoneno;
        this.email = email;
        this.address = address;
    }

    public int getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", phoneno=" + phoneno +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

