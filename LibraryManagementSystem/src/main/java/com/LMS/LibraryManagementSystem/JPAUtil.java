package com.LMS.LibraryManagementSystem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");

	// Method to get an EntityManager instance
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// Method to close the EntityManagerFactory
	public static void close() {
		emf.close();
	}
	
	
}
