package com.pn.hibernatedemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pn.hibernatedemo.entities.Company;
import com.pn.hibernatedemo.entities.Employee;

public class DemoInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Company company = new Company();
		company.setName("Google");
		entityManager.persist(company);

		Employee emp1 = new Employee();
		emp1.setName("kai");
		emp1.setCompany(company);
		
		Employee emp2 = new Employee();
		emp2.setName("nguyen");
		emp2.setCompany(company);
		
		entityManager.persist(emp1);
		entityManager.persist(emp2);
		
		entityManager.getTransaction().commit();
		System.out.println("after insert");
		System.out.println(company);
		System.out.println(emp1);
		System.out.println(emp2);
		entityManager.close();
		entityManagerFactory.close();
	}

}
