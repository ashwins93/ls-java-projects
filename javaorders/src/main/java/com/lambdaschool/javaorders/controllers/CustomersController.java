package com.lambdaschool.javaorders.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	// POST /api/customers
	@PostMapping(value = "", consumes = {"application/json"})
	public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customer customer) {
		Customer newCustomer = service.saveCustomer(customer);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newCustomerURI = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCustomer.getCustcode())
				.toUri();
		responseHeaders.setLocation(newCustomerURI);
		
		return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
	}
}
