package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Payment;

public interface PaymentService {
	public Payment findPaymentById(long id);
}
