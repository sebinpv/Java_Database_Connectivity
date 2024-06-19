package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {
	public Connection getConnection() throws ClassNotFoundException {
		String connectionURL = "jdbc:mysql://localhost:3306/bank_db?useSSL=false";
        String userName = "root";
        String password = "experion@123";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
		return connection;
	}
	
	public Connection closeConnection(Connection connection)
	{
		try {
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		return connection;
	}
	
	public ArrayList<Customer> getAllCustomers(Connection connection){
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Statement statement;
		ResultSet resultSet;
		try {

			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from customer");
			
			while(resultSet.next()) {
				int customerCode = resultSet.getInt(1);
				String customerFirstName = resultSet.getString(2);
				String customerLastName = resultSet.getString(3);
				String address = resultSet.getString(4);
				long phNumber = resultSet.getLong(5);
				long aadharNo = resultSet.getLong(6);
				
				Customer customer = new Customer(customerCode,customerFirstName,customerLastName,address,phNumber,aadharNo);
				customerList.add(customer);			}
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		return customerList;
	}
	
	public void insertIntoCustomer(Connection connection, Customer customer) {
		
		PreparedStatement statement = null;
		
		try {
			String sql = "INSERT INTO customer (customer_firstname, customer_lastname, address, phnumber, aadhar_no) " +
			        "VALUES (?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getCustomerFirstName());
            statement.setString(2, customer.getCustomerLastName());
            statement.setString(3, customer.getAddress());
            statement.setLong(4, customer.getPhNumber());
            statement.setLong(5, customer.getAadharNo());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("New customer inserted successfully!");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCustomer(Connection connection, Customer customer) {
		
		PreparedStatement statement = null;
		
		try {
			String sql = "UPDATE customer SET customer_firstname = ?, customer_lastname = ?, address = ?, phnumber = ?, aadhar_no = ? " +
	                 "WHERE customer_code = ?";
		    statement = connection.prepareStatement(sql);
		    statement.setString(1, customer.getCustomerFirstName());
		    statement.setString(2, customer.getCustomerLastName());
		    statement.setString(3, customer.getAddress());
		    statement.setLong(4, customer.getPhNumber());
		    statement.setLong(5, customer.getAadharNo());
		    statement.setInt(6, customer.getCustomerCode());
            
		    int rowsUpdated = statement.executeUpdate();
		    if (rowsUpdated > 0) {
		        System.out.println("Customer updated successfully!");
		    } else {
		        System.out.println("No customer found with customer code: " + customer.getCustomerCode());
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
