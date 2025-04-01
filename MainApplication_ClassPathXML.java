package com.spring.IOCDemo;

import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication_ClassPathXML {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Tax tax = context.getBean(IncomeTax.class);
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter payment Mode: ");
            String paymentMode = sc.nextLine().toLowerCase(); 
            
            tax.setTaxableAmount(150000);
            tax.payTax(paymentMode);
            tax.getTaxAmount();
            
            sc.close();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
