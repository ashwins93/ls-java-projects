package com.lambdaschool.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lambdaschool.javaorders.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
