package com.LMS.LibraryManagementSystem;
 
import java.time.LocalDate;

import com.LMS.LibraryManagementSystem.service.FineCalculator; 

import jakarta.persistence.EntityManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	EntityManager em = JPAUtil.getEntityManager();
    	
    	try {
    	em.getTransaction().begin();
    	Author author = new Author("Robert Kiyosaki");
    	em.persist(author);
    	Book book1 = new Book("Rich Dad Poor Dad", author); 
    	em.persist(book1);
    	FineCalculator fc = new FineCalculator();
    	Member member = new Member("Yash", "Yash@gmail.com", "Active");
    	member.borrowBook(book1, LocalDate.now().minusDays(14), fc.calcFine(member));
    	em.persist(member);
    	
    	System.out.println("The fine amount for "+ member.getName()+ ", is: " + fc.calcFine(member));
    	em.getTransaction().commit();
    	} catch (Exception e) {
    	e.printStackTrace();
    }
    	
    	em.close();
    	JPAUtil.close();
	}
}
