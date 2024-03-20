package repositories;

import org.example.models.Employees;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryEmployees extends RepositoryBase{


    public RepositoryEmployees() throws SQLException {
    }
    public void insert(Employees employees) throws SQLException{


        var pstmt = getConnection().prepareStatement("INSERT INTO customers (employeeName,employeePhoneno,employeePosition,cemployeeEmail)" +
                " VALUES (?,?);");


        pstmt.setInt(1, employees.getEmployeeId());
        pstmt.setString(1, employees.getEmployeeName());
        pstmt.setInt(2, employees.getPhoneno());
        pstmt.setString(2, employees.getPosition());
        pstmt.setString(2, employees.getEmail());



        pstmt.executeUpdate();
    }

    public List<Employees> getAll() throws SQLException {
        var employees = new ArrayList<Employees>();
        var stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT employeeId, employeeName, employeeEmail, employeeContactno, employeePosition FROM employees;");
        while (resultSet.next()){
            var employees1 = new Employees();

            employees1.setEmployeeId(resultSet.getInt("employeeId"));
            employees1.setEmployeeName(resultSet.getString("employeeName"));
            employees1.setEmail(resultSet.getString("employeeEmail"));
            employees1.setPhoneno(resultSet.getInt("employeeContactno"));
            //employees.getPo(resultSet.getString("employeePosition"));

            employees.add(employees1);
        }
        return employees;

    }
}

