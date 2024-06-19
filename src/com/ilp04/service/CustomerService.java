package com.ilp04.service;

import java.util.ArrayList;

import com.ilp04.entity.Customer;

public interface CustomerService {
	public ArrayList<Customer> getAllCustomer();
	public void insertIntoCustomer(Customer customer);
	public void updateCustomer(Customer customer);
}
