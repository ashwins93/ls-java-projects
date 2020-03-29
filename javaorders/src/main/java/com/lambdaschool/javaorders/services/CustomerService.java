package com.lambdaschool.javaorders.services;

import java.util.List;

import com.lambdaschool.javaorders.models.Customer;

public interface CustomerService {
	public List<Customer> findAllCustomers();
	
	public Customer findCustomerById(long id);
	
	public Customer searchCustomerByName(String namelike);
}
