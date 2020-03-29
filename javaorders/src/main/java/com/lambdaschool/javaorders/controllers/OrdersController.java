package com.lambdaschool.javaorders.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	@Autowired
	private OrderService service;
	
	@GetMapping(value = "/{id}", produces = {"application/json"})
	public ResponseEntity<?> getOrderById(@PathVariable long id) {
		Order foundOrder = service.findOrderById(id);
		
		return new ResponseEntity<>(foundOrder, HttpStatus.OK);
	}
}
