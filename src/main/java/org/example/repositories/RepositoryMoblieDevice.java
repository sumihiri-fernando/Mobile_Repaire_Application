package repositories;

import org.example.models.MobileDevice;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositoryMoblieDevice extends RepositoryBase{

    public RepositoryMoblieDevice() throws SQLException {
    }
    public void insert(MobileDevice moblieDevice) throws SQLException {


        var pstmt = getConnection().prepareStatement("INSERT INTO customers (customer_name,customer_contactno,customer_address,customer_email)" +
                " VALUES (?,?);");


        pstmt.setInt(1, moblieDevice.getMobileDeviceId());
        pstmt.setInt(1, moblieDevice.getCustomerId());
        pstmt.setString(2, moblieDevice.getSerialNo());
        pstmt.setString(2, moblieDevice.getCustomerMobileImage());



        pstmt.executeUpdate();
    }

    public ArrayList<MobileDevice> getAll() throws SQLException {
        ArrayList<MobileDevice> moblieDevice = new ArrayList<>();
        var stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT moblieDeviceId, moblieDeviceName, Model, serialNo, customerMobileImage FROM moblieDevice;");
        while (resultSet.next()) {
            var moblieDevice1 = new MobileDevice("mobileDeviceId", "customerId", "model", "serialNo", "customerMobileImage");

            moblieDevice1.setMobileDeviceId(resultSet.getInt("MobileDeviceId"));
            moblieDevice1.setCustomerId(resultSet.getInt("CustomerId"));
            moblieDevice1.setModel(resultSet.getString("Model"));
            moblieDevice1.setSerialNo(resultSet.getString("SerialNo"));
            moblieDevice1.setCustomerMobileImage(resultSet.getString("CustomerMobileImage"));

            moblieDevice.add(moblieDevice1);
        }
        return  moblieDevice;

    }
}
  /*private int moblieDevice;
        private int customerId;
        private String model;
        private String serialNo;
        private String customerMobileImage;*/