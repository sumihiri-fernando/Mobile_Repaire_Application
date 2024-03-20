package org.example.repositories;


import org.example.models.Customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RepositoryCustomers extends RepositoryBase {
    public RepositoryCustomers() throws SQLException {
        super();
    }

    public void insert(Customers customers) throws SQLException{

        var pstmt = getConnection().prepareStatement("INSERT INTO customers (customerName,customerContactno,customerAddress,customerEmail )" +
                " VALUES (?,?,?,?);");


       // pstmt.setInt(1, customers.getCustomerId());
        pstmt.setString(1, customers.getCustomerName());
        pstmt.setInt(2, customers.getCustomerContactno());
        pstmt.setString(3, customers.getCustomerAddress());
        pstmt.setString(4, customers.getCustomerEmail());



        pstmt.executeUpdate();


    }

    public ArrayList<Customers> getAll() throws SQLException {

        var customers = new ArrayList<Customers>();
        Statement stmt;
        stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT customerId, customerName, customerEmail, customerContactno, customerAddress FROM customers;");
        //System.out.println(resultSet.getArray(1));
        while (resultSet.next()){
            var customers1 = new Customers();

            customers1.setCustomerId(resultSet.getInt("customerId"));
            customers1.setCustomerName(resultSet.getString("customerName"));
            customers1.setCustomerEmail(resultSet.getString("customerEmail"));
            customers1.setCustomerContactno(resultSet.getInt("customerContactno"));
            customers1.setCustomerAddress(resultSet.getString("customerAddress"));

            customers.add(customers1);
        }
        return customers;

    }

    public void updateCustomer(int customerIdNum, String customerNewName, String customerNewEmail) throws SQLException {
        var stmt = getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM customers WHERE customerId=" + customerIdNum);
        if (resultSet.next()) {
            stmt.executeUpdate("UPDATE customers SET customerName='" + customerNewName + "', customerEmail='" + customerNewEmail + "' WHERE customerId=" + customerIdNum);
            System.out.println("Customer id: " + customerIdNum + " has been updated in the database.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void deleteCustomer(int customerIdNum) throws SQLException {
        var stmt = getConnection().createStatement();
        ResultSet invoiceResultSet = stmt.executeQuery("SELECT * FROM invoice WHERE customerId=" + customerIdNum);
        if (!invoiceResultSet.next()) {
            // No associated invoices found, proceed with deleting the customer
            try {
                stmt.executeUpdate("DELETE FROM customers WHERE customerId=" + customerIdNum);
                System.out.println("Customer id: " + customerIdNum + " has been deleted from the database.");
            } catch (SQLException e) {
                System.out.println("Failed to delete customer. An error occurred.");
            }
        } else {
            System.out.println("Failed to delete customer. Customer is associated with invoices.");
        }
    }
}




