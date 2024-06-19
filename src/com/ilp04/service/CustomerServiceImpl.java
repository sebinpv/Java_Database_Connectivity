package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public ArrayList<Customer> getAllCustomer() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		CustomerDAO  customerDAO = new CustomerDAO();
		Connection connection;
		try {
			connection = customerDAO.getConnection();
			customerList = customerDAO.getAllCustomers(connection);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return customerList;
	}

	@Override
	public void insertIntoCustomer(Customer customer) {
		CustomerDAO  customerDAO = new CustomerDAO();
		Connection connection;
		try {
			connection = customerDAO.getConnection();
			customerDAO.insertIntoCustomer(connection,customer);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		CustomerDAO  customerDAO = new CustomerDAO();
		Connection connection;
		try {
			connection = customerDAO.getConnection();
			customerDAO.updateCustomer(connection,customer);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
