package repositories;

import org.example.models.Branch;
import java.sql.SQLException;
import java.util.ArrayList;

public class RepositoryBranch extends RepositoryBase {
    public RepositoryBranch() throws SQLException {
        super();
    }

    public void insert(Branch branch) throws SQLException {


        var pstmt = getConnection().prepareStatement("INSERT INTO customers (BranchName,BranchPhoneno,BranchAddress,BranchEmail)" +
                " VALUES (?,?);");


        pstmt.setInt(1, branch.getBranchId());
        pstmt.setString(1, branch.getBranchName());
        pstmt.setInt(2, branch.getPhoneno());
        pstmt.setString(2, branch.getEmail());
        pstmt.setString(2, branch.getAddress());


        pstmt.executeUpdate();
    }

    public ArrayList<Branch> getAll() throws SQLException {
        var branch = new ArrayList<Branch>();
        var stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT BranchId, BranchName, BranchEmail, BranchPhoneno, BranchAddress FROM Branch;");
        while (resultSet.next()) {
            var branch1 = new Branch();

            branch1.setBranchId(resultSet.getInt("BranchId"));
            branch1.setBranchName(resultSet.getString("BranchName"));
            branch1.setEmail(resultSet.getString("BranchEmail"));
            branch1.setPhoneno(resultSet.getInt("BranchPhoneno"));
            branch1.setAddress(resultSet.getString("BranchAddress"));

            branch.add(branch1);
        }
        return branch;

    }
}