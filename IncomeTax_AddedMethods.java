package com.spring.IOCDemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

interface Tax {
	void calculateTaxAmount();

	double getTaxAmount();

	void setTaxableAmount(double amount);

	String getTaxType();

	boolean isTaxPayed();

	void payTax(String method);
}

@Component("incomeTax")
public class IncomeTax implements Tax {

	private double taxableAmount;
	private double taxAmount;
	private boolean taxPaid;
	private final String taxType = "Income";

	private final Map<String, PaymentProcessor> paymentProcessors;

	@Autowired
	public IncomeTax(Map<String, PaymentProcessor> paymentProcessors) {
		this.paymentProcessors = paymentProcessors;

	}

	@Override
	public void setTaxableAmount(double amount) {
		this.taxableAmount = amount;
		calculateTaxAmount();
	}

	@Override
	public void calculateTaxAmount() {
		if (taxableAmount >= 0 && taxableAmount <= 50000) {
			this.taxAmount = (this.taxableAmount * 0.00);
		} else if (taxableAmount > 50000 && taxableAmount <= 100000) {
			this.taxAmount = (this.taxableAmount * 0.05);
		} else if (taxableAmount > 100000 && taxableAmount <= 800000) {
			this.taxAmount = (this.taxableAmount * 0.10);
		} else {
			this.taxAmount = (this.taxableAmount * 0.15);
		}
		System.out.println("Tax Amount: " + this.taxAmount);
	}

	@Override
	public double getTaxAmount() {
		return taxAmount;
	}

	@Override
	public String getTaxType() {
		return taxType;
	}

	@Override
	public boolean isTaxPayed() {
		return taxPaid;
	}

	public void payTax(String method) {
		PaymentProcessor processor = paymentProcessors.get(method.toLowerCase());
		if (processor != null) {
			processor.doPayment();
			System.out.println("Tax paid using: " + method + "\nAmount: " + taxAmount);
		} else {
			System.out.println("Invalid payment method: " + method);
		}
	}

}
