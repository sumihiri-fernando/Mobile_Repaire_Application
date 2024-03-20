package org.example.models;

public class Employees {
    private int employeeId;
    private String employeeName;
    private int branchId;
    private int phoneno;
    private String email;
    private String position;

    public Employees() {
    }

    public Employees(int employeeId, String employeeName, int branchId, int phoneno, String email, String position) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.branchId = branchId;
        this.phoneno = phoneno;
        this.email = email;
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getBranchId() {
        return branchId;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", branchId=" + branchId +
                ", phoneno=" + phoneno +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}


