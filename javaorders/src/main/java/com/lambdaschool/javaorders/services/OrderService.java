package com.lambdaschool.javaorders.services;

import java.util.List;

import com.lambdaschool.javaorders.models.Order;

public interface OrderService {
	public List<Order> findAllOrders();
	
	public List<Order> findOrdersWithAdvance();
	
	public Order findOrderById(long id);
	
	public Order saveOrder(Order order);
	
	public Order updateOrder(Order order);
	
	public void deleteOrder(long id);
}
