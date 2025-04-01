package com.spring.IOCDemo;

import org.springframework.stereotype.Component;

interface Tax {
    void calculateTaxAmount();
    double getTaxAmount();
    void setTaxableAmount(double amount);
    String getTaxType();
    boolean isTaxPayed();
    void payTax(); 
    
    
}

@Component("incomeTax")
public class IncomeTax implements Tax {
    private double taxableAmount;
    private double taxAmount;
    private boolean taxPaid;
    private final String taxType = "Income";
    
    @Override
    public void setTaxableAmount(double amount) {
        this.taxableAmount = amount;
        calculateTaxAmount();
    }

    @Override
    public void calculateTaxAmount() {
    	if(taxableAmount >= 0 && taxableAmount <= 50000) {
    		this.taxAmount = (this.taxableAmount  * 0.00);
    	}else if (taxableAmount >= 50001 && taxableAmount <= 800000) {
    		this.taxAmount = (this.taxableAmount  * 0.05); 
        } else if (taxableAmount >= 100001 && taxableAmount <= 1000000) {
    		this.taxAmount = (this.taxableAmount  * 0.10);   
        } else {
    		this.taxAmount = (this.taxableAmount  * 0.15);
        } 
    	
    	System.out.println("Tax Amount: "+this.taxAmount);
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

	 
	 
}
