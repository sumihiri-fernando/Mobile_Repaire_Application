package org.example;


import org.example.models.Customers;
import org.example.models.Employees;


import org.example.repositories.RepositoryCustomers;
import org.example.repositories.RepositoryEmployees;


import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        //CRUD OPERATION FOR CUSTOMERS
        var repo = new RepositoryCustomers();
        var newCustomer = addNewCustomer();
        //Create new Employee
        repo.insert(newCustomer);
        //Read all the Customers
        var customers = repo.getAll();
        for (var customer : customers) {
            System.out.println(customer);
        }
        //Update a selected customer
        repo.updateCustomer(001, "Hans L", "hansl@123gmail.com");
        //Delete a selected customer
        repo.deleteCustomer(001);


        //CRUD OPERATION FOR EMPLOYEES
        var repoEmp = new RepositoryEmployees();
        var newEmployee = addNewEmployee();
        //Create new Employee
        repoEmp.insert(newEmployee);
        //Read all the Employee
        var employees = repoEmp.getAll();
        for (var employee : employees) {
            System.out.println(employee);
        }
        //Update a selected employee
        repoEmp.updateEmployees(001, "Hans L", 54321, 776756675, "hansl@123gmail.com", "UX Engineer");
        //Delete a selected employee
        repoEmp.deleteEmployee(001);
    }

    private static Customers addNewCustomer() {
        return new Customers(001, "Hans G", "hansg@123gmail.com", 0767554151, "Sadelmakargatan 34");
    }

    private static Employees addNewEmployee() {
        return new Employees(001, "Adam M", 54320, 77554151, "adam@gmail.com", "Vallingatan 34");
    }


}




