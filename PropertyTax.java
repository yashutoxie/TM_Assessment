package com.spring.IOCDemo;

public class PropertyTax implements Tax {
	private double taxableAmount;
	private double taxAmount;
	private boolean taxPaid;
	private final String taxType = "Property";
	private static final double TAX_RATE = 0.05;
	
	

	@Override
	public void calculateTaxAmount() {
		this.taxAmount = (this.taxableAmount * TAX_RATE); 
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

	@Override
	public void payTax() {
		if (taxAmount > 0) {
			taxPaid = true;
			System.out.println("Tax paid: " + taxAmount);
		} else {
			System.out.println("No tax due.");
		}
	}

	@Override
	public void setTaxableAmount(double amount) {
		this.taxableAmount = amount;
		calculateTaxAmount();
	}

	 

}
