package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RepositoryBase {

    private Connection conn;

    private static final String url = "jdbc:mysql://database-anorth-1.rds.amazonaws.com:3306/mobileRrepaire_application";
    private static final String user = "root";
    private static final String pass = "admin123";


    public RepositoryBase() throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        createTables();
    }

    private void createTables() throws SQLException {
        var sql ="CREATE TABLE IF NOT EXISTS customers(\n" +
                "customer_id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "customer_name VARCHAR(255),\n" +
                "customer_email VARCHAR(255),\n" +
                "customer_contactno VARCHAR(255),\n" +
                "customer_address VARCHAR(255);";

        var sql1 =   "CREATE TABLE IF NOT EXISTS mobileDevice (\n" +
                "\tmobileDevice_id INT PRIMARY KEY AUTO_INCREMENT ,\n" +
                "customer_id INT NOT NULL,\n" +
                "model VARCHAR(255) NOT NULL,\n" +
                "serial_no VARCHAR(255) ,\n" +
                "customer_mobile_image VARCHAR (255),\n" +
                "FOREIGN KEY (customer_id) REFERENCES customers (customer_id); ";

        var sql2 = "CREATE TABLE IF NOT EXISTS branch (\n" +
                "\tbranch_id INT PRIMARY KEY AUTO_INCREMENT ,\n" +
                "    branch_name VARCHAR(255) NOT NULL,\n" +
                "    phoneno INT NOT NULL,\n" +
                "    email VARCHAR(255) ,\n" +
                "    address VARCHAR (255);";

        var sql3 = "CREATE TABLE IF NOT EXISTS employees (\n" +
                "\temployee_id INT PRIMARY KEY AUTO_INCREMENT ,\n" +
                "    employee_name VARCHAR(255)NOT NULL,\n" +
                "    branch_id INT NOT NULL,\n" +
                "    phoneno INT NOT NULL,\n" +
                "    email VARCHAR(255) ,\n" +
                "    position VARCHAR (255);";




               /* "CREATE TABLE IF NOT EXISTS furnitures(" +
                "furniture_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "furniture_name VARCHAR(255) NOT NULL, " +
                "furniture_type VARCHAR(255) NOT NULL);";*/



        getConnection().createStatement().execute(sql);
    }

    protected static Connection getConnection(){
        return conn;
    }
}

