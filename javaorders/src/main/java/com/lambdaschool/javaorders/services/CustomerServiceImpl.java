package com.lambdaschool.javaorders.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

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
		Customer foundCustomer = custrepos
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found " + id));
		
		return foundCustomer;
	}

	@Override
	public List<Customer> searchCustomerByName(String namelike) {
		List<Customer> customers = new ArrayList<>();
		
		custrepos.findAll()
			.iterator()
			.forEachRemaining(customer -> {
				if(customer.getCustname().contains(namelike)) {
					customers.add(customer);
				}
			});
		
		return customers;
	}

}
