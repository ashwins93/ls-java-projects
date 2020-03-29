package com.lambdaschool.javaorders.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.repositories.OrderRepository;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderrepos;

	@Override
	public Order findOrderById(long id) {
		Order foundOrder = orderrepos.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Order not found " + id));
		
		return foundOrder;
	}

}
