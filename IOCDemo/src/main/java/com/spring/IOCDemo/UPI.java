package com.spring.IOCDemo;

import org.springframework.stereotype.Component;

@Component("upi")
public class UPI implements PaymentProcessor {

	@Override
	public void doPayment() {
		System.out.println("Paid Through UPI");
	}

}
