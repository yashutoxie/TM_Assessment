package com.jpa.DemoJpa;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) { 
				
				EntityManager em=JPAUtil.getEntityManager();
		 
				em.getTransaction().begin();
				Employee emp2 = em.find(Employee.class, 1);
				 System.out.println(emp2.getName());
				 System.out.println(emp2.getId());
				
//				 emp2.setSalary(50000);
				
				 em.detach(emp2);
				 em.getTransaction().commit();
//				em.remove(emp2);
				em.close();
				
				JPAUtil.close();
			}
}