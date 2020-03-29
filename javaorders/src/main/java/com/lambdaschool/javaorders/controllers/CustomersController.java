package com.lambdaschool.javaorders.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<?> getAllCustomers() {
		List<Customer> customers = service.findAllCustomers();
		
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
