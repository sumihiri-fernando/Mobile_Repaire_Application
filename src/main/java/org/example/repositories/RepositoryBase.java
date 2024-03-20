package org.example.repositories;

import java.sql.*;

public class RepositoryBase {

    private Connection conn;

    private static final String url = "jdbc:mysql://localhost:3306/mobile";
    private static final String user = "root";
    private static final String pass = "Msn123@msn";


    public RepositoryBase() throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        createTables();
    }

    private void createTables() throws SQLException {
        try (Statement statement = conn.createStatement()) {
            // Check if customers table exists
            ResultSet resultSet = conn.getMetaData().getTables(null, null, "customers", null);
            if (!resultSet.next()) {
                String sql = "CREATE TABLE customers (\n" +
                        "    customerId INT PRIMARY KEY AUTO_INCREMENT,\n" +
                        "    customerName VARCHAR(255),\n" +
                        "    customerEmail VARCHAR(255),\n" +
                        "    customerContactno VARCHAR(255),\n" +
                        "    customerAddress VARCHAR(255)\n" +
                        ")";
                statement.execute(sql);
            }

            // Similar checks for other tables
            // Check if mobileDevice table exists
            resultSet = conn.getMetaData().getTables(null, null, "mobileDevice", null);
            if (!resultSet.next()) {
                String sql1 = "CREATE TABLE mobileDevice (\n" +
                        "    mobileDevice_id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                        "    customerId INT NOT NULL,\n" +
                        "    model VARCHAR(255) NOT NULL,\n" +
                        "    serialNo VARCHAR(255),\n" +
                        "    customerMobileImage VARCHAR(255),\n" +
                        "    FOREIGN KEY (customerId) REFERENCES customers (customerId)\n" +
                        ")";
                statement.execute(sql1);
            }

            // Similar checks for other tables
            // Check if branch table exists
            resultSet = conn.getMetaData().getTables(null, null, "branch", null);
            if (!resultSet.next()) {
                String sql2 = "CREATE TABLE branch (\n" +
                        "    branchId INT PRIMARY KEY AUTO_INCREMENT,\n" +
                        "    branchName VARCHAR(255) NOT NULL,\n" +
                        "    phoneno INT NOT NULL,\n" +
                        "    email VARCHAR(255),\n" +
                        "    address VARCHAR(255)\n" +
                        ")";
                statement.execute(sql2);
            }

            // Similar checks for other tables
            // Check if employees table exists
            resultSet = conn.getMetaData().getTables(null, null, "employees", null);
            if (!resultSet.next()) {
                String sql3 = "CREATE TABLE employees (\n" +
                        "    employeeId INT PRIMARY KEY AUTO_INCREMENT,\n" +
                        "    employeeName VARCHAR(255) NOT NULL,\n" +
                        "    branchId INT NOT NULL,\n" +
                        "    phoneno INT NOT NULL,\n" +
                        "    email VARCHAR(255),\n" +
                        "    position VARCHAR(255)\n" +
                        ")";
                statement.execute(sql3);
            }

            // Similar checks for other tables
            // Check if Invoice table exists
            resultSet = conn.getMetaData().getTables(null, null, "Invoice", null);
            if (!resultSet.next()) {
                String sql4 = "CREATE TABLE Invoice (\n" +
                        "    invoiceId INT NOT NULL PRIMARY KEY,\n" +
                        "    customerId INT NOT NULL,\n" +
                        "    deviceId INT NOT NULL,\n" +
                        "    invoiceCreatedById INT NOT NULL,\n" +
                        "    deviceAllocatedId INT,\n" +
                        "    branchId INT NOT NULL,\n" +
                        "    paymentmethod VARCHAR(255) NOT NULL,\n" +
                        "    repaireCost INT NOT NULL,\n" +
                        "    issuedDate DATE NOT NULL,\n" +
                        "    deadline DATE NOT NULL,\n" +
                        "    statuses VARCHAR(255) NOT NULL,\n" +
                        "    FOREIGN KEY (customerId) REFERENCES customers(customerId),\n" +
                        "    FOREIGN KEY (deviceId) REFERENCES mobileDevice(mobileDevice_id),\n" +
                        "    FOREIGN KEY (invoiceCreatedById) REFERENCES employees(employeeId),\n" +
                        "    FOREIGN KEY (branchId) REFERENCES branch(branchId)\n" +
                        ")";
                statement.execute(sql4);
            }
        }
    }


    protected Connection getConnection(){
        return conn;
    }
}

