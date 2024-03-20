package org.example;

import org.example.models.Customers;
import org.example.models.Employees;

import org.example.repositories.RepositoryCustomers;
import org.example.repositories.RepositoryEmployees;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        while (true) {
            try {
                System.out.print("\n### Main Menu ###\n" +
                        "1. Customers\n" +
                        "2. Employees\n" +
                        "Enter selection: ");

                Scanner scanner = new Scanner(System.in);
                String input = scanner.next();


                int inputSelection = Integer.parseInt(input);
                handleMenuSelection(inputSelection);


            } catch (NumberFormatException e) {
                System.out.println("INVALID NUMBER");
            }
        }

    }

    private static void handleMenuSelection(int inputSelection) throws SQLException {
        switch (inputSelection) {
            case 1:
                System.out.print("\n### Menu Customers ###\n" +
                        "1. Show customers\n" + // Read
                        "2. Add customer (not implemented)\n" + // Create
                        "3. Update customer (not implemented)\n" + // Update
                        "4. Delete customer (not implemented)\n" + // Delete
                        "Enter selection: ");

                Scanner scanner = new Scanner(System.in);
                String input = scanner.next();


                int inputSelectionCustomer = Integer.parseInt(input);
                handleMenuCustomersSelection(inputSelectionCustomer);
                break;
            case 2:
                System.out.print("\n### Menu Employees###\n" +
                        "1. Show Employees\n" + // Read
                        "2. Add Employee (not implemented)\n" + // Create
                        "3. Update Employees (not implemented)\n" + // Update
                        "4. Delete Employees (not implemented)\n" + // Delete
                        "Enter selection: ");

                Scanner scanner1 = new Scanner(System.in);
                String input1 = scanner1.next();


                int inputSelectionEmployees = Integer.parseInt(input1);
                handleMenuEmployeesSelection(inputSelectionEmployees);
                break;
            default: // If not valid input, print error
                System.out.println("Invalid selection");
                break;
        }

    }


    // Calls correct function based on input selection
    private static void handleMenuCustomersSelection(int selection) throws SQLException {

        switch (selection) {
            case 1:
                showCustomers();
                break;
            case 2:
                addNewCustomer();
                break;
            case 3:
                updateCustomers();
                break;
            case 4:
                deleteCustomers();
                break;
            default: // If not valid input, print error
                System.out.println("Invalid selection");
                break;
        }

    }
    private static void handleMenuEmployeesSelection(int selection) throws SQLException {

        switch (selection) {
            case 1:
                showEmployees();
                break;
            case 2:
                addNewEmployee();
                break;
            case 3:
                updateEmployee();
                break;
            case 4:
                deleteEmployees();
                break;
            default: // If not valid input, print error
                System.out.println("Invalid selection");
                break;
        }

    }
    private static void updateCustomers() throws SQLException {
        var repo = new RepositoryCustomers();

        Customers newCustomer = new Customers();

        System.out.print("Enter ID");
        Scanner scannerCustomerIDNo = new Scanner(System.in);
        String CustomerIDNoIF = scannerCustomerIDNo.next();

        if(CustomerIDNoIF != null){
            newCustomer.setCustomerId(Integer.parseInt(CustomerIDNoIF));
            System.out.print("If You Want To Enter Customer Name : Yes/No");
            Scanner scannerCustomerNameIF = new Scanner(System.in);
            String CustomerNameIF = scannerCustomerNameIF.next();
            if(CustomerNameIF.equals("YES")){
                System.out.print("Enter Customer Name : ");
                Scanner scannerCustomerName = new Scanner(System.in);
                String CustomerName = scannerCustomerName.next();

                newCustomer.setCustomerName(CustomerName);
            }

            System.out.print("If You Want To Enter Customer Email : Yes/No");
            Scanner scannerCustomerEmailIF = new Scanner(System.in);
            String CustomerEmailIF = scannerCustomerEmailIF.next();

            if(CustomerEmailIF.equals("YES")){
                System.out.print("Enter Customer Email : ");
                Scanner scannerCustomerEmail = new Scanner(System.in);
                String CustomerEmail = scannerCustomerEmail.next();

                newCustomer.setCustomerEmail(CustomerEmail);
            }///

            System.out.print("If You Want To Enter Customer Address : Yes/No");
            Scanner scannerCustomerAddressIF = new Scanner(System.in);
            String CustomerAddressIF = scannerCustomerAddressIF.next();

            if(CustomerAddressIF.equals("YES")){
                System.out.print("Enter Customer Address : ");
                Scanner scannerCustomerAddress = new Scanner(System.in);
                String CustomerAddress = scannerCustomerAddress.next();

                newCustomer.setCustomerAddress(CustomerAddress);
            }

            System.out.print("If You Want To Enter Customer Phone No : Yes/No");
            Scanner scannerCustomerPhoneNoIF = new Scanner(System.in);
            String CustomerPhoneNoIF = scannerCustomerPhoneNoIF.next();

            if(CustomerPhoneNoIF.equals("YES")){
                System.out.print("Enter Customer Phone No : ");
                Scanner scannerCustomerPhoneNo = new Scanner(System.in);
                String CustomerPhoneNo = scannerCustomerPhoneNo.next();

                newCustomer.setCustomerContactno(Integer.parseInt(CustomerPhoneNo));
            }
        }
        repo.updateCustomer(newCustomer.getCustomerId(), newCustomer.getCustomerName(), newCustomer.getCustomerEmail());
    }
    private static void updateEmployee() throws SQLException {
        var repo = new RepositoryEmployees();

        Employees newEmployee = new Employees();

        System.out.print("Enter ID");
        Scanner scannerEmployeeIDNo = new Scanner(System.in);
        String EmployeeIDNoIF = scannerEmployeeIDNo.next();

        if (EmployeeIDNoIF != null) {
            newEmployee.setEmployeeId(Integer.parseInt(EmployeeIDNoIF));
            System.out.print("If You Want To Enter Employee Name : Yes/No");
            Scanner scannerEmployeeNameIF = new Scanner(System.in);
            String EmployeeNameIF = scannerEmployeeNameIF.next();
            if (EmployeeNameIF.equals("YES")) {
                System.out.print("Enter Employee Name : ");
                Scanner scannerEmployeeName = new Scanner(System.in);
                String EmployeeName = scannerEmployeeName.next();

                newEmployee.setEmployeeName(EmployeeName);
            }

            System.out.print("If You Want To Enter Employee Email : Yes/No");
            Scanner scannerEmployeeEmailIF = new Scanner(System.in);
            String EmployeeEmailIF = scannerEmployeeEmailIF.next();

            if (EmployeeEmailIF.equals("YES")) {
                System.out.print("Enter Employee Email : ");
                Scanner scannerEmployeeEmail = new Scanner(System.in);
                String EmployeeEmail = scannerEmployeeEmail.next();

                newEmployee.setEmail(EmployeeEmail);
            }
            System.out.print("If You Want To Enter Employee Branch : Yes/No");
            Scanner scannerEmployeeBranchIF = new Scanner(System.in);
            String EmployeeBranchIF = scannerEmployeeBranchIF.next();

            if (EmployeeBranchIF.equals("YES")) {
                System.out.print("Enter Employee Branch: ");
                Scanner scannerEmployeeBranch = new Scanner(System.in);
                String EmployeeBranch = scannerEmployeeBranch.next();

                newEmployee.setBranchId(Integer.parseInt(EmployeeBranch));///
            }

            System.out.print("If You Want To Enter Employee Phone No : Yes/No");
            Scanner scannerEmployeePhoneNoIF = new Scanner(System.in);
            String EmployeePhoneNoIF = scannerEmployeePhoneNoIF.next();

            if (EmployeePhoneNoIF.equals("YES")) {
                System.out.print("Enter Employee Phone No : ");
                Scanner scannerEmployeePhoneNo = new Scanner(System.in);
                String EmployeePhoneNo = scannerEmployeePhoneNo.next();

                newEmployee.setPhoneno(Integer.parseInt(EmployeePhoneNo));
            }
            System.out.print("If You Want To Enter Employee Position : Yes/No");
            Scanner scannerPositionIF = new Scanner(System.in);
            String EmployeePositionIF = scannerPositionIF.next();

            if (EmployeePositionIF.equals("YES")) {
                System.out.print("Enter Employee Position : ");
                Scanner scannerEmployeePosition = new Scanner(System.in);
                String EmployeePosition = scannerEmployeePosition.next();

                newEmployee.setEmail(EmployeePosition);

            }
        }
        repo.updateEmployees(newEmployee.getEmployeeId(), newEmployee.getEmployeeName(), newEmployee.getBranchId(),newEmployee.getPosition());
    }

    private static void addNewCustomer () throws SQLException {
        Customers newCustomer = new Customers();

        System.out.print("Enter Customer Name : ");
        Scanner scannerCustomerName = new Scanner(System.in);
        String CustomerName = scannerCustomerName.next();

        newCustomer.setCustomerName(CustomerName);

        System.out.print("Enter Customer Email : ");
        Scanner scannerCustomerEmail = new Scanner(System.in);
        String CustomerEmail = scannerCustomerEmail.next();

        newCustomer.setCustomerEmail(CustomerEmail);

        System.out.print("Enter Customer Phone No : ");
        Scanner scannerCustomerPhoneNo = new Scanner(System.in);
        String CustomerPhoneNo = scannerCustomerPhoneNo.next();

        newCustomer.setCustomerContactno(Integer.parseInt(CustomerPhoneNo));

        System.out.print("Enter Customer Address : ");
        Scanner scannerCustomerAddress = new Scanner(System.in);
        String CustomerAddress = scannerCustomerAddress.next();

        newCustomer.setCustomerAddress(CustomerAddress);

        var repo = new RepositoryCustomers();

        repo.insert(newCustomer);
        System.out.println("New user add");
    }
    private static void addNewEmployee () throws SQLException {
        Employees newEmployees = new Employees();

        System.out.print("Enter Employee Name : ");
        Scanner scannerEmployeeName = new Scanner(System.in);
        String EmployeeName = scannerEmployeeName.next();

        newEmployees.setEmployeeName(EmployeeName);

        System.out.print("Enter Employee Email : ");
        Scanner scannerEmployeeEmail = new Scanner(System.in);
        String EmployeeEmail = scannerEmployeeEmail.next();

        newEmployees.setEmail(EmployeeEmail);

        System.out.print("Enter Employee Phone No : ");
        Scanner scannerEmployeePhoneNo = new Scanner(System.in);
        String EmployeePhoneNo = scannerEmployeePhoneNo.next();

        newEmployees.setPhoneno(Integer.parseInt(EmployeePhoneNo));

        System.out.print("Enter Employee Branch Id : ");
        Scanner scannerEmployeeBranchId = new Scanner(System.in);
        String EmployeeBranchId = scannerEmployeeBranchId.next();

        newEmployees.setBranchId(Integer.parseInt(EmployeeBranchId));

        System.out.print("Enter Employee Position : ");
        Scanner scannerEmployeePosition = new Scanner(System.in);
        String EmployeePosition = scannerEmployeePosition.next();

        newEmployees.setPosition(EmployeePosition);


        var repo = new RepositoryEmployees();

        repo.insert(newEmployees);
        System.out.println("New user add");
    }

    private static void deleteCustomers () throws SQLException {
        var repo = new RepositoryCustomers();

        System.out.print("Enter ID");
        Scanner scannerCustomerIDNo = new Scanner(System.in);
        String CustomerIDNoIF = scannerCustomerIDNo.next();

        //Delete a selected customer
        repo.deleteCustomer(Integer.parseInt(CustomerIDNoIF));
    }

    private static void deleteEmployees () throws SQLException {
        var repo = new RepositoryEmployees();

        System.out.print("Enter ID");
        Scanner scannerEmployeesIDNo = new Scanner(System.in);
        String EmployeesIDNoIF = scannerEmployeesIDNo.next();

        //Delete a selected customer
        repo.deleteEmployee(Integer.parseInt(EmployeesIDNoIF));
    }

    private static void showCustomers () throws SQLException {
        var repo = new RepositoryCustomers();
        //Read all the Customers

        var customers = repo.getAll();
        for (var customer : customers) {
            System.out.println(customer);
        }
    }

    private static void showEmployees () throws SQLException {
        var repo = new RepositoryEmployees();

        //Read all the Employees
        var employees = repo.getAll();
        for (var employee : employees) {
            System.out.println(employee);
        }
    }
}

