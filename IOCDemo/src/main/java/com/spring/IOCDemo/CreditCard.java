package com.spring.IOCDemo;

import org.springframework.stereotype.Component;

@Component("creditcard")
public class CreditCard implements PaymentProcessor {

	@Override
	public void doPayment() {
		System.out.println("Payment Done through Credit Card");
	}

}
