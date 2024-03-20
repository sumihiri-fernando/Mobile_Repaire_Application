package org.example.repositories;

import org.example.models.MobileDevice;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RepositoryMoblieDevice extends RepositoryBase {

    public RepositoryMoblieDevice() throws SQLException {
        super();
    }

    public void insert(MobileDevice moblieDevice) throws SQLException {


        var pstmt = getConnection().prepareStatement("INSERT INTO customers (deviceId,brand,model,serialno)" +
                " VALUES (?,?,?,?);");


        pstmt.setInt(1, moblieDevice.getMobileDeviceId());
        pstmt.setString(1, moblieDevice.getBrand());
        pstmt.setString(2, moblieDevice.getModel());
        pstmt.setString(2, moblieDevice.getSerialNo());


        pstmt.executeUpdate();
    }

    public ArrayList<MobileDevice> getAll() throws SQLException {
        var moblieDevice = new ArrayList<MobileDevice>();
        Statement stmt;

        stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT moblieDeviceId, moblieDeviceName, Model, serialNo, customerMobileImage FROM moblieDevice;");
        while (resultSet.next()) {
            var moblieDevice1 = new MobileDevice();

            moblieDevice1.setMobileDeviceId(resultSet.getInt("MobileDeviceId"));
            moblieDevice1.setCustomerId(resultSet.getInt("CustomerId"));
            moblieDevice1.setModel(resultSet.getString("Model"));
            moblieDevice1.setSerialNo(resultSet.getString("SerialNo"));
            moblieDevice1.setBrand(resultSet.getString("CustomerMobileImage"));

            moblieDevice.add(moblieDevice1);
        }
        return moblieDevice;

    }

    public void updatemoblieDevicer(int moblieDeviceId, int CustomerId, String Newmodel, String NewSerialNo) throws SQLException {
        var moblieDevice = new ArrayList<MobileDevice>();
        var stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT moblieDeviceId, CustomerId, model, serialNo,  FROM moblieDevice;");
        while (resultSet.next()) {
            for (MobileDevice moblieDevice1 : moblieDevice) {
                {
                    if (moblieDevice1.getMobileDeviceId() == moblieDeviceId) {
                        stmt.executeQuery("UPDATE moblieDevice SET model= Newmodel, serialNo=NewserialNo WHERE moblieDevice=moblieDevice1;");
                        System.out.print("MoblieDevice id: " + moblieDevice1 + " has updated in DB.");
                    } else {
                        System.out.print("moblieDevice has not found.");
                    }

                }
            }
        }
    }

    public void deleteMoblieDevice(int moblieDeviceIdNum) throws SQLException {
        var moblieDevice = new ArrayList<MobileDevice>();
        var stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT Moblie_Device, brand, model, serialno FROM moblieDevice;");
        while (resultSet.next()) {
            for (MobileDevice moblieDeviceA : moblieDevice) {
                {
                    if (moblieDeviceA.getMobileDeviceId() == moblieDeviceIdNum) {
                        stmt.executeQuery("DELETE FROM moblieDevice WHERE moblieDevice=customerIdNum");
                        System.out.print("MoblieDevice id: " + moblieDeviceIdNum + " has deleted from DB.");
                    } else {
                        System.out.print("Customer has not found.");
                    }

                }
            }
        }
    }
}


