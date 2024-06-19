package com.ilp04.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;

public class CustomerUtility {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1- Display Customers");
            System.out.println("2- Insert Customer");
            System.out.println("3- Update Customer");
            System.out.println("4- Delete Customer");
            System.out.println("0- Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    getAllCustomers();
                    break;
                case 2:
                    insertIntoCustomer();
                    break;
                case 0:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 0 to exit.");
                    break;
            }
        } while (choice != 0);
	}
	public static void getAllCustomers() {
		CustomerService customerService = new CustomerServiceImpl();
		ArrayList<Customer> customerList = customerService.getAllCustomer();
		System.out.println("Customer Code FirstName LastName Address Phone No. Aadhar No.");
		for (Customer customer : customerList) {
			
			 System.out.println("    "+customer.getCustomerCode()+"\t"+customer.getCustomerFirstName()+"\t"+customer.getCustomerLastName()+"\t"+customer.getAddress()+"\t"+customer.getPhNumber()+"\t"+customer.getAadharNo());
        }
       
	}
	public static void insertIntoCustomer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Customer Firstname:");
		String customerFirstName = scanner.nextLine();
		System.out.println("Enter Customer Lastname:");
		String customerLastName = scanner.nextLine();
		System.out.println("Enter Customer Address:");
		String address = scanner.nextLine();
		System.out.println("Enter Customer Phone No.:");
		long phNumber = scanner.nextLong();
		System.out.println("Enter Customer Aadhar No.:");
		long aadharNo = scanner.nextLong();
		
		Customer customer = new Customer(customerFirstName,customerLastName,address,phNumber,aadharNo);
		
		CustomerService customerService = new CustomerServiceImpl();
		
		customerService.insertIntoCustomer(customer);
	}
	
	public static void updateCustomer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Customer Code:");
		int customerCode = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Customer Firstname:");
		String customerFirstName = scanner.nextLine();
		System.out.println("Enter Customer Lastname:");
		String customerLastName = scanner.nextLine();
		System.out.println("Enter Customer Address:");
		String address = scanner.nextLine();
		System.out.println("Enter Customer Phone No.:");
		long phNumber = scanner.nextLong();
		System.out.println("Enter Customer Aadhar No.:");
		long aadharNo = scanner.nextLong();
		
		Customer customer = new Customer(customerCode,customerFirstName,customerLastName,address,phNumber,aadharNo);
		
		CustomerService customerService = new CustomerServiceImpl();
		
		customerService.insertIntoCustomer(customer);
	}
}
