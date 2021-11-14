package com.pn.hibernatedemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pn.hibernatedemo.entities.Company;

public class DemoSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Company company = entityManager.find(Company.class, 1);
		System.out.println(company);
		
		company.getListEmployee().forEach(employee -> System.out.println(employee));
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
