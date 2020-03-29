package com.lambdaschool.javaorders.services;

import java.util.List;

import com.lambdaschool.javaorders.models.Order;

public interface OrderService {
	public List<Order> findAllOrders();
	
	public List<Order> findOrdersWithAdvance();
	
	public Order findOrderById(long id);
}
