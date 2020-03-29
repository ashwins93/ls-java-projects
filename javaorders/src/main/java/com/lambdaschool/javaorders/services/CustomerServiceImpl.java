package com.lambdaschool.javaorders.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.CustomerRepository;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository custrepos;

	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		custrepos.findAll().iterator().forEachRemaining(customers::add);
		
		return customers;
	}

	@Override
	public Customer findCustomerById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer searchCustomerByName(String namelike) {
		// TODO Auto-generated method stub
		return null;
	}

}
