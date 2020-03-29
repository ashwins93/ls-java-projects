package com.lambdaschool.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lambdaschool.javaorders.models.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
