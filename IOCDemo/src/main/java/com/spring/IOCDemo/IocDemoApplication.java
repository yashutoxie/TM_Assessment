package com.spring.IOCDemo;

import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.apache.catalina.core.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Configuration
//@ComponentScan(basePackages = "com.spring.IOCDemo")
public class IocDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(IocDemoApplication.class, args);
//		IncomeTax  tax = new IncomeTax();

//		Spring to create object of IncomeTax

//		specify the path for spring application context xml to
//		read the file and creates the objects.
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//			Tax tax = (IncomeTax) context.getBean("incomeTax", IncomeTax.class);
//			
//			tax.setTaxableAmount(80000);
//			tax.calculateTaxAmount();
//			System.out.println("Tax Amount for 8: " + tax.getTaxAmount());
//			
//			tax.setTaxableAmount(1 500000); 
//			System.out.println("Tax Amount for 15: " + tax.getTaxAmount());
//			
//			tax.setTaxableAmount(500000);
//			System.out.println("Tax Amount for 5: " + tax.getTaxAmount());
//			
//			Tax property = (PropertyTax) context.getBean("propertyTax", PropertyTax.class);
//			System.out.println("Property Tax: ");
//			property.setTaxableAmount(10000);
//			property.calculateTaxAmount();
//			System.out.println("Property Tax Amount: " +  property.getTaxAmount());
//			context.close();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocDemoApplication.class)) {
			Tax tax = context.getBean(IncomeTax.class);
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter payment Mode: ");
			String paymentMode = sc.nextLine().toLowerCase(); 
			tax.setTaxableAmount(150000);
			tax.payTax(paymentMode);
			tax.getTaxAmount();
			sc.close();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
