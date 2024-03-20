package org.example.repositories;


import org.example.models.Invoice;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RepositoryInvoice extends RepositoryBase {

    public RepositoryInvoice() throws SQLException {
        super();
    }
    public void insert(Invoice invoice) throws SQLException{


        var pstmt = getConnection().prepareStatement("INSERT INTO Invoice (customer_id, device_id, invoice_created_by_id, device_allocated_id, branch_id, paymentmethod, repaire_cost, issued_date, deadline, statuses )" +
                " VALUES (?,?,?,?,?,?,?,?,?,?);");


        pstmt.setInt(1, invoice.getInvoiceId());
        pstmt.setInt(1, invoice.getCustomerId());
        pstmt.setInt(2, invoice.getDeviceId());
        pstmt.setInt(2, invoice.getInvoiceCreatedById());
        pstmt.setInt(2, invoice.getDevice_allocatedId());
        pstmt.setInt(2, invoice.getBranchId());
        pstmt.setInt(2, invoice.getRepaireCost());
        pstmt.setInt(2, invoice.getDeviceId());
        pstmt.setString(2, invoice.getIssuedDate());
        pstmt.setString(2, invoice.getDeadline());
        pstmt.setString(2, invoice.getPaymentmethod());
        pstmt.setString(2, invoice.getStatuses());



        pstmt.executeUpdate();
    }

    public ArrayList<Invoice> readAll() throws SQLException {
        var invoice = new ArrayList<Invoice>();
        Statement stmt;
        stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT invoiceId, customerId, deviceId, invoiceCreatedById, deviceAllocatedId, branchId, paymentmethod, repaireCost, issuedDate, deadline, statuses FROM cinvoice;");
        while (resultSet.next()){
            var invoice1 = new Invoice();


            invoice1.setInvoiceId(resultSet.getInt("invoiceId"));
            invoice1.setCustomerId(resultSet.getInt("customerId"));
            invoice1.setDeviceId(resultSet.getInt("deviceId"));
            invoice1.setInvoiceCreatedById(resultSet.getInt("invoiceCreatedById"));
            invoice1.setInvoiceCreatedById(resultSet.getInt("deviceAllocatedId"));
            invoice1.setBranchId(resultSet.getInt("branchId"));
            invoice1.setPaymentmethod(resultSet.getString("paymentmethod"));
            invoice1.setRepaireCost(resultSet.getInt("repaireCost"));
            invoice1.setIssuedDate(String.valueOf(resultSet.getInt("issuedDate")));
            invoice1.setDeadline(resultSet.getString("deadline"));
            invoice1.setStatuses(resultSet.getString("statuses"));


            invoice.add(invoice1);
        }
        return invoice;

    }

    public void updateInvoice(int invoiceId,int customerId, int deviceId, int invoiceCreatedById, int deviceAllocatedId, int branchId, String paymentmethod, String repaireCost,  int issuedDate, int deadline, String statuses ) throws SQLException {
        var invoice = new ArrayList<Invoice>();
        var stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT invoiceId,customerId,deviceId, invoiceCreatedById, deviceAllocatedId, branchId, paymentmethod, repaireCost,  issuedDate,  deadline, statuses FROM invoice;");
        while (resultSet.next()) {
            for (Invoice invoice1: invoice) {
                {
                    if (invoice1.getInvoiceId()== invoiceId) {
                        stmt.executeQuery("UPDATE invoice" +
                           "invoiceId = NewinvoiceId, customerId=NewcustomerId, deviceId= NewdeviceId, invoiceCreatedById=NewdeviceId, deviceAllocatedId= NewdeviceAllocatedId, branchId= NewbranchId, paymentmethod= Newpaymentmethod, repaireCost= Newpaymentmethod,  issuedDate= NewissuedDate,  deadline= Newdeadline, statuses= Newdeadline WHERE invoiceId= invoice1;");

                        System.out.print("Invoice Id: " + invoice1 + " has updated in DB.");
                    } else {
                        System.out.print("Invoice has not found.");
                    }

                }}}}

    public void deleteInvoice(int invoiceIdNum) throws SQLException {
        var invoice = new ArrayList<Invoice>();
        var stmt = getConnection().createStatement();
        var resultSet = stmt.executeQuery("SELECT invoiceId,customerId,deviceId, invoiceCreatedById, deviceAllocatedId, branchId, paymentmethod, repaireCost,  issuedDate,  deadline, statuses FROM invoice ;");
        while (resultSet.next()) {
            for (Invoice invoiceA : invoice) {
                {
                    if (invoiceA.getInvoiceId() == invoiceIdNum) {
                        stmt.executeQuery("DELETE FROM invoice WHERE invoiceId=invoiceIdNum");
                        System.out.print("Invoice id: " + invoiceIdNum + " has deleted from DB.");
                    } else {
                        System.out.print("Invoice has not found.");
                    }

                }}}}

}