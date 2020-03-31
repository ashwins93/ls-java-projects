package com.lambdaschool.javaorders.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambdaschool.javaorders.models.Payment;
import com.lambdaschool.javaorders.repositories.PaymentRepository;

@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository payrepos;

	@Override
	public Payment findPaymentById(long id) {
		Payment payment = payrepos.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Payme with id " + id + " not found."));
		
		return payment;
	}

}
