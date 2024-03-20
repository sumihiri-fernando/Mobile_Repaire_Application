
import org.example.models.Employees;
import org.example.repositories.RepositoryEmployees;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class RepositoryEmployeesTest {

    private Connection mockConnection;
    private PreparedStatement mockStatement;
    private ResultSet mockResultSet;
    private RepositoryEmployees RepositoryEmployee;

    @BeforeEach
    public void setUp() throws SQLException {

        // Skapar mock-objekt
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
        when(mockResultSet.getInt("employeeId")).thenReturn(1);
        when(mockResultSet.getString("employeeName")).thenReturn("Test customerName");
        when(mockResultSet.getString("employeeEmail")).thenReturn("Test customerEmail");
        when(mockResultSet.getInt("employeeContactno")).thenReturn(243453);
        when(mockResultSet.getString("employeePosition")).thenReturn("Test customerAddress");

        // Skapar en instans av DrinkRepository med mock-anslutningen
        RepositoryEmployee = new RepositoryEmployees() {
            @Override
            protected Connection getConnection() {
                return mockConnection;
            }
        };
    }

    @Test
    public void testCreate() throws SQLException {
        Employees employees = new Employees(001, "Niklas Berg", 54230, 767755554, "niklas.berg@shop.com", "Technician");

        RepositoryEmployee.insert(employees);

        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).setInt(1, employees.getEmployeeId());
        verify(mockStatement).setInt(1, employees.getBranchId());
        verify(mockStatement).setString(2, employees.getEmployeeName());
        verify(mockStatement).setString(3, employees.getPosition());
        verify(mockStatement).setInt(4, employees.getPhoneno());
        verify(mockStatement).setString(5, employees.getEmail());
        verify(mockStatement).executeUpdate();
    }

    /*employeeId;
            private String employeeName;
            private int branchId;
            private int phoneno;
            private String email;
            private String position;*/
    @Test
    public void testRead() throws SQLException {
        Employees employees = new Employees();
        RepositoryEmployee.getAll();

        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).executeUpdate();
    }

    @Test
    public void testUpdate() throws SQLException {
        Employees employees = new Employees();
        RepositoryEmployee.updateEmployees(001, "Hans L", 54321, "hansl@123gmail.com");

        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).setInt(1, employees.getEmployeeId());
        verify(mockStatement).setString(2, employees.getEmployeeName());
        verify(mockStatement).setString(3, employees.getEmail());
        verify(mockStatement).executeUpdate();
    }


    @Test
    public void testDelete() throws SQLException {
        Employees employees = new Employees();
        RepositoryEmployee.deleteEmployee(001);

        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).executeUpdate();
    }

}




