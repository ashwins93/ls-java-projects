package com.lambdaschool.javaorders.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.models.Payment;
import com.lambdaschool.javaorders.repositories.OrderRepository;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderrepos;
	
	@Autowired
	private PaymentService paymentService;

	@Override
	public Order findOrderById(long id) {
		Order foundOrder = orderrepos.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Order not found " + id));
		
		return foundOrder;
	}

	@Override
	public List<Order> findAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		orderrepos.findAll().iterator().forEachRemaining(orders::add);
		
		return orders;
	}

	@Override
	public List<Order> findOrdersWithAdvance() {
		List<Order> orders = new ArrayList<Order>();
		orderrepos.findAll().iterator().forEachRemaining(order -> {
			if(order.getAdvanceamount() > 0) {
				orders.add(order);
			}
		});
		
		return orders;
	}
}
