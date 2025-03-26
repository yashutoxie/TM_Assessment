package com.jpa.relationsJPA; 
import java.util.List;

import jakarta.persistence.EntityManager; 

public class App {
    public static void main(String[] args) { 
    	EntityManager em = JPAUtil.getEntityManager(); //        em.getTransaction().begin();
    	em.getTransaction().begin(); 
//        em.persist(new User("Zayn", "zayn@gmail.com", "Active")); 
//        em.getTransaction().commit();
        List<User> statusList = em.createNamedQuery("User.findByStatus", User.class)
        		.setParameter(1, "Active")        	
        		.getResultList();
        
        for(User s: statusList) {
        	System.out.println(s.getName());
        }
//    	List<User> users1 = em.createQuery("select u from User u where u.name=:name", User.class)
//    	        .setParameter("name", "Zayn")
//    	        .getResultList();
//    	for(User user : users1) {
//    		System.out.println(user.getName());
//    	}
//    	List<User> emailUsers = em.createNamedQuery("User.findByEmail", User.class)
//    			.setParameter("email","Yash@gmail.com")
//    			.getResultList();
//    	for(User u : emailUsers) {
//    		System.out.println(u.getEmail());
//    	}
    	
//    	int deletedCount = em.createQuery("delete from User u where u.name =: name")
//    			.setParameter("name", "Yash").executeUpdate();
//    	System.out.println(deletedCount+" Records Deleted");
//    	for (User u : users1) {
//    	    System.out.println(u.getName());
//    	} 

        	
//        	em.getTransaction().commit();
//        Book fetchedBook = em.find(Book.class, 1);
//        System.out.println(fetchedBook.getAuthor().getBooks()+" ");

        // Create Author and Books
//        Author author = new Author("George Orwell");
//        em.persist(author);
//        Author authorToDelete = em.createQuery("SELECT a FROM Author a WHERE a.name = :name", Author.class)
//                .setParameter("name", "George Orwell")
//                .getSingleResult();
//em.remove(authorToDelete);
//em.p
//        em.flush();
//        em.remove(author); 
//        Book book1 = new Book("1984");
//        Book book2 = new Book("Animal Farm");
//
//        // Establish relationship
//        book1.setAuthor(author);
//        book2.setAuthor(author); 
//        em.persist(book1);
//        em.persist(book2);
        em.getTransaction().commit();  
        em.close();
        JPAUtil.close();

//        System.out.println("Data persisted successfully!");
    }
}
