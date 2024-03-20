package org.example.repositories;


import org.example.models.Employees;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;


public class RepositoryEmployees extends RepositoryBase {

    public RepositoryEmployees() throws SQLException {
       // super();
    }

    public void insert(Employees employees) throws SQLException {


        var pstmt = getConnection().prepareStatement("INSERT INTO employees (employeeName,employeePhoneno,employeePosition,employeeEmail,branchId)" +
                " VALUES (?,?,?,?,?);");


        pstmt.setString(1, employees.getEmployeeName());
        pstmt.setInt(2, employees.getPhoneno());
        pstmt.setString(3, employees.getPosition());
        pstmt.setString(4, employees.getEmail());
        pstmt.setInt(5, employees.getBranchId());

        pstmt.executeUpdate();
    }

    public ArrayList<Employees> getAll() throws SQLException {
        var employees = new ArrayList<Employees>();
        Statement stmt;
        stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT employeeId, employeeName, employeeEmail, employeePhoneno, employeePosition FROM employees;");
        while (resultSet.next()) {
            var employees1 = new Employees();

            employees1.setEmployeeId(resultSet.getInt("employeeId"));
            employees1.setEmployeeName(resultSet.getString("employeeName"));
            employees1.setEmail(resultSet.getString("employeeEmail"));
            employees1.setPhoneno(resultSet.getInt("employeePhoneno"));
            //employees.getP(resultSet.getString("position"));

            employees.add(employees1);
        }
        return employees;

    }

    public void updateEmployees(int employeeId, String employeeNewName, int branchNewId, String employeeNewEmail) throws SQLException {
        var stmt = getConnection().createStatement();

        ResultSet resultSet = stmt.executeQuery("SELECT * FROM employees WHERE employeeId=" + employeeId);
        System.out.println(10000);
                    if (resultSet.next()) {
                       // System.out.println("UPDATE employees SET employeeName='" + employeeNewName+"', employeeEmail='"+employeeNewEmail+"' WHERE employeeId='"+employeeId);
                        stmt.executeUpdate("UPDATE employees SET employeeName='" + employeeNewName+"', employeeEmail='"+employeeNewEmail+"' WHERE employeeId='"+employeeId+"';");
                        System.out.print("Employees id: " + employeeId + " has updated in DB.");
                    } else {
                        System.out.println(10003);
                        System.out.print("Employees has not found.");
                    }


    }

    public void deleteEmployee(int employeeId) throws SQLException {
        var stmt = getConnection().createStatement();
       // ResultSet invoiceResultSet = stmt.executeQuery("SELECT * FROM invoice WHERE employeeId=" + employeeId);
        //if (!invoiceResultSet.next()) {
            // No associated invoices found, proceed with deleting the customer
            try {
                stmt.executeUpdate("DELETE FROM employees WHERE employeeId=" + employeeId);
                System.out.println("Employees id: " + employeeId + " has been deleted from the database.");
            } catch (SQLException e) {
                System.out.println("Failed to delete customer. An error occurred.");
            }
        //} else {
           // System.out.println("Failed to delete customer. Customer is associated with invoices.");
        //}
    }

}
