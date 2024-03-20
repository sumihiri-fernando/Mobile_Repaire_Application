package repositories;

import org.example.models.Customers;

import java.sql.SQLException;
import java.util.ArrayList;


public class RepositoryCustomers extends RepositoryBase {
    public RepositoryCustomers() throws SQLException {
        super();
    }

    public static void insertCustomer(Customers customers) throws SQLException{


        var pstmt = getConnection().prepareStatement("INSERT INTO customers (customerName,customerContactno,customerAddress,customerEmail )" +
                " VALUES (?,?);");


        pstmt.setInt(1, customers.getCustomerId());
        pstmt.setString(1, customers.getCustomerName());
        pstmt.setInt(2, customers.getCustomerContactno());
        pstmt.setString(2, customers.getCustomerAddress());
        pstmt.setString(2, customers.getCustomerEmail());



        pstmt.executeUpdate();
    }

    public static ArrayList<Customers> readAll() throws SQLException {
        var customers = new ArrayList<Customers>();
        var stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT customerId, customerName, customerEmail, customerContactno, customerAddress FROM customers;");
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

    public static void updateCustomer(int customerIdNum,String customerNewName,String customerNewEmail) throws SQLException {
        var customers = new ArrayList<Customers>();
        var stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT customerId, customerName, customerEmail, customerContactno, customerAddress FROM customers;");
        while (resultSet.next()) {
            for (Customers customersA : customers) {
                {
                    if (customersA.getCustomerId() == customerIdNum) {
                        stmt.executeQuery("UPDATE customers SET customerName= customerNewName, customerEmail=customerNewEmail WHERE customerId=customerIdNum;");
                        System.out.print("Customer id: " +customerIdNum+" has updated in DB.");
                    } else {
                        System.out.print("Customer has not found.");
                    }
                }
            }
        }
    }


    public void deleteCustomer(int customerIdNum) throws SQLException {
        var customers = new ArrayList<Customers>();
        var stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT customerId, customerName, customerEmail, customerContactno, customerAddress FROM customers;");
        while (resultSet.next()) {
            for (Customers customersA : customers) {
                {
                    if (customersA.getCustomerId() == customerIdNum) {
                        stmt.executeQuery("DELETE FROM FROM customers WHERE customerId=customerIdNum;");
                        System.out.print("Customer id: " +customerIdNum+" has deleted from DB.");
                    } else {
                        System.out.print("Customer has not found.");
                    }
                }
            }
        }
    }

}