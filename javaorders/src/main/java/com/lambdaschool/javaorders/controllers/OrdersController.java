package com.lambdaschool.javaorders.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	@Autowired
	private OrderService service;
	
	@GetMapping(value = "", produces = {"application/json"})
	public ResponseEntity<?> getAllOrders(@RequestParam(name = "advance", required = false) String answer) {
		List<Order> orders = new ArrayList<Order>();
		
		if(answer != null && answer.toLowerCase() == "yes") {
			orders.addAll(service.findOrdersWithAdvance());
		} else {
			orders.addAll(service.findAllOrders());
		}
		
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json"})
	public ResponseEntity<?> getOrderById(@PathVariable long id) {
		Order foundOrder = service.findOrderById(id);
		
		return new ResponseEntity<>(foundOrder, HttpStatus.OK);
	}
	
	@PostMapping(value = "", consumes = {"application/json"})
	public ResponseEntity<?> createOrder(@Valid  @RequestBody Order order) {
		Order newOrder = service.saveOrder(order);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		URI locationURI = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newOrder.getOrdnum())
				.toUri();
		responseHeaders.setLocation(locationURI);
		
		return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = {"application/json"})
	public ResponseEntity<?> updateOrder(@RequestBody Order order, @PathVariable long id) {
		order.setOrdnum(id);
		service.updateOrder(order);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable long id) {
		service.deleteOrder(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
