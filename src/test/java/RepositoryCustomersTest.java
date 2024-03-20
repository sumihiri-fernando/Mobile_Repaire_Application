import org.example.models.Customers;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.example.repositories.RepositoryCustomers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class RepositoryCustomersTest {

    private Connection mockConnection;
    private PreparedStatement mockStatement;
    private ResultSet mockResultSet;
    private RepositoryCustomers RepositoryCustomers;

    @BeforeEach
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        mockStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // När getConnection anropas ska mock-anslutningen returneras
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // När executeUpdate anropas ska inget hända
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);

        // När executeQuery anropas ska mock-resultatet returneras
        when(mockResultSet.next()).thenReturn(true, false); // Simulate one result in the ResultSet
        when(mockResultSet.getInt("customerId")).thenReturn(1);
        when(mockResultSet.getString("customerName")).thenReturn("Test customerName");
        when(mockResultSet.getString("customerEmail")).thenReturn("Test customerEmail");
        when(mockResultSet.getInt("customerContactno")).thenReturn(243453);
        when(mockResultSet.getString("customerAddress")).thenReturn("Test customerAddress");

        // Skapar en instans av DrinkRepository med mock-anslutningen
        RepositoryCustomers = new RepositoryCustomers() {
            @Override
            protected Connection getConnection() {
                return mockConnection;
            }
        };
    }

    @Test
    public void testCreate() throws SQLException {
        Customers customers = new Customers(001, "Hans G", "hansg@123gmail.com", 0767554151, "Sadelmakargatan 34");
        RepositoryCustomers.insert(customers);

        verify(mockConnection).prepareStatement(anyString());
        //verify(mockStatement).setInt(1, customers.getCustomerId());
        verify(mockStatement).setString(1, customers.getCustomerName());
        verify(mockStatement).setString(4, customers.getCustomerEmail());
        verify(mockStatement).setInt(2, customers.getCustomerContactno());
        verify(mockStatement).setString(3, customers.getCustomerAddress());
        verify(mockStatement).executeUpdate();
    }

    @Test
    public void testRead() throws SQLException {
        Customers customers = new Customers();
        RepositoryCustomers.getAll();

        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).executeUpdate();
    }

    @Test
    public void testUpdate() throws SQLException {
        Customers customers = new Customers();
        RepositoryCustomers.updateCustomer(001, "Hans L", "hansl@123gmail.com");

        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).setInt(1, customers.getCustomerId());
        verify(mockStatement).setString(2, customers.getCustomerName());
        verify(mockStatement).setString(3, customers.getCustomerEmail());
        verify(mockStatement).executeUpdate();
    }


    @Test
    public void testDelete() throws SQLException {
        Customers customers = new Customers();
        RepositoryCustomers.deleteCustomer(001);

        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).executeUpdate();
    }

}

