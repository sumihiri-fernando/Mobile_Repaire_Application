# Mobile Repair Application 

This project aims to develop a comprehensive program for a mobile repair company to manage repair jobs, mobile devices, and customers. The system will include functionalities for CRUD operations on these resources and integration with AWS S3 for file uploads.

## Development Process

1. **Database Model Design:** Designed a suitable database schema with five tables in the MySQL workbench:`Customers`,`MobileDevices`,`Employees`,`Branch`and `Invoice`.
2. **Database Creation:** Set up the database on AWS RDS, utilizing MySQL workbench as the database engine.
3. **Application Development:** Developed a web-based application using Django framework to allow users to CRUD all resources.
4. **Testing:** Implemented unit tests using Django's testing framework to ensure correctness of CRUD operations against a mock database.
5. **Integration with AWS tdfffdfgtS3:** Added functionality to upload files (e.g., images of device damage) to AWS S3 and associated each file with a repair job or customer.
6. **Documentation:** Documented the entire process, including database structure, program functions, and code structure.

## Database Structure

### The database consists of the following tables:

#### Customers
- customerId 
- customerName 
- customerEmail 
- customerContactno 
- customerAddress 
- customerMobileImage 

#### Branch 
- branchId
- branchName 
- email 
- phoneno 

#### Moblie Device 
- deviceId 
- brand 
- model 
- serialno

#### Employees
- employeeId 
- employeeName 
- email 
- phoneno 
- position 
- branchId

#### Invoice
- invoiceId 
- customerId 
- deviceId 
- invoiceCreatedById
- deviceAllocatedId
- branchId 
- paymentmethod 
- repaireCost 
- issuedDate 
- deadline 
- statuses 


## Functions

The application provides the following functionalities:

1. **Create:** Allow users to create new Customer ,MobileDevice,Employee,Branch and Invoice.
2. **Read:** Enable users to view details of Customers ,MobileDevices,Employees,Branch and Invoice.
3. **Update:** Allow users to update information related to Customer ,MobileDevice,Employee,Branch and Invoice.
4. **Delete:** Permit users to delete Customer ,MobileDevice,Employee,Branch and Invoice.
5. **File Upload :** Allow users to upload files (images or other relevant documents) associated with repair jobs or customers.fffffffffffffffffffff

## Code Structure

The codebase is structured as follows:

- **Database Interaction:** Contains code for connecting to the database and executing CRUD operations.
- **Models:** Includes Django model classes representing database entities.
- **Views:** Django views for handling HTTP requests and containing business logic.jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
- **Templates:** HTML templates for rendering the user interface.
- **Tests:** Unit tests to ensure functionality correctness.hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
- **AWS S3 Integration:** Contains code for uploading files to AWS S3.


## CRUD Operations Testing with Mock Database
This project demonstrates how to write tests for CRUD (Create, Read, Update, Delete) operations against a mock database in Java using JUnit and Mockito.

### Dependencies
JUnit: A popular Java testing framework used to write and run repeatable tests.
Mockito: A mocking framework that allows you to create and configure mock objects for testing.

` <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.2</version>
            <scope>test</scope>
        </dependency>`,
   ` <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency> `.

### Test Structure
The tests are organized in the following structure:

- CreateOperationTest.java: Tests for the create operation.
- ReadOperationTest.java: Tests for the read operation.
- UpdateOperationTest.java: Tests for the update operation.
- DeleteOperationTest.java: Tests for the delete operation.

Each test class contains methods that test individual CRUD operations against the mock database.

### Mock Database
The mock database is simulated using Mockito. It provides mock implementations of database interfaces and allows you to define behavior for different database operations.

## Connecting MySQL Workbench with AWS RDS Database
This guide outlines the steps to connect MySQL Workbench or DBGate with a MySQL database hosted on Amazon RDS (Relational Database Service) and then connect IntelliJ IDEA with the database.

# Prerequisites
Before you begin, ensure you have the following:

- Access to an AWS account with permissions to manage RDS instances.
- An RDS MySQL database instance created and accessible from the internet.
- MySQL Workbench or DBGate installed on your local machine.
- IntelliJ IDEA installed on your local machine.

##  Steps to Connect MySQL Workbench with AWS RDS
#### Open MySQL Workbench:
- Launch MySQL Workbench on your local machine.

#### Create a New Connection:
  
- Click on the "+" icon next to "MySQL Connections" to create a new connection.
- Enter the connection details:
1. Connection Name: Provide a name for your connection.
2. Hostname: Endpoint of your RDS instance (can be found in the RDS dashboard).
3. Port: Default MySQL port is 3306.
4. Username: MySQL username configured for your RDS instance.
5. Password: MySQL password configured for your RDS instance.
- Click "OK" to save the connection.

#### Connecting IntelliJ IDEA with the Database
Once you have connected MySQL Workbench or DBGate with your AWS RDS MySQL database, you can connect IntelliJ IDEA to the same database using JDBC.

- Open IntelliJ IDEA:
Launch IntelliJ IDEA on your local machine.

- Install dependencies in Maven
  ` <dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <version>8.3.0</version>
  </dependency>`.

- Open Project:
Open your Java project in IntelliJ IDEA.

- Configure Data Source:

Go to `View` > `Tool Windows` > `Database`.
Click on the "+" icon and select `Data Source` > `MySQL`.
Enter the database connection details:
Host: Endpoint of your RDS instance.
Port: Default MySQL port is 3306.
Database: Name of your MySQL database.
User: MySQL username configured for your RDS instance.
Password: MySQL password configured for your RDS instance.
Click "Test Connection" to ensure the connection is successful.
Click "OK" to save the data source configuration.
Connect to the Database:
Double click on the data source you just configured to establish a connection to your AWS RDS MySQL database from IntelliJ IDEA.

#### Test Connection:
Click on the connection you just created and click "Test Connection" to ensure it is successful.

#### Connect to the Database:
Double click on the connection to establish a connection to your AWS RDS MySQL database.

## Setup Instructions

1. Clone the repository: `git clone https://github.com/Distansakademin/dbh-vt24-inlamning-sumihiri-fernando.git
2.
  
3. Set up environment variables for database connection and AWS S3 credentials.
4. Run migrations: `python manage.py migrate`
5. Start the development server: `python manage.py runserver`
6. Access the application at `http://localhost:8000`

## Contributors

- John Doe (@johndoe)
- Jane Smith (@janesmith)

## License

This project is licensed under the MIT License.
