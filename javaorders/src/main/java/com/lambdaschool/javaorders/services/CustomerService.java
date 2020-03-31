package com.lambdaschool.javaorders.services;

import java.util.List;

import com.lambdaschool.javaorders.models.Customer;

public interface CustomerService {
	public List<Customer> findAllCustomers();
	
	public Customer findCustomerById(long id);
	
	public List<Customer> searchCustomerByName(String namelike);
	
	public Customer saveCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer, long id);
	
	public void deleteCustomerById(long id);
}
