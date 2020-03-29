package com.lambdaschool.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lambdaschool.javaorders.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
