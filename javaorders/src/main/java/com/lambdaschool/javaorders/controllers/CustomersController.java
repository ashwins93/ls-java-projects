package com.lambdaschool.javaorders.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
	@Autowired
	private CustomerService service;

	// GET /api/customers
	@GetMapping(value = "", produces = {"application/json"})
	public ResponseEntity<?> getAllCustomers(
			@RequestParam(value = "name", required = false) String namelike) {
		List<Customer> customers = new ArrayList<Customer>();
		
		if(namelike != null) {
			customers.addAll(service.searchCustomerByName(namelike));
		} else {
			customers.addAll(service.findAllCustomers());
		}
		
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	// GET /api/customers/{id}
	@GetMapping(value = "/{id}", produces = { "application/json" })
	public ResponseEntity<?> getCustomerById(@PathVariable long id) {
		Customer customer = service.findCustomerById(id);

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	// GET /api/customers
}
