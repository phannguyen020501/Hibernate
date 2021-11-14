package com.pn.hibernatedemo;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pn.hibernatedemo.entities.Employee;


public class DemoSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		System.out.println("demo select");
		Employee emp = entityManager.find(Employee.class, 1);
		System.out.println(emp);
		
		System.out.println("demo after remove one position");
		emp.getPositions().remove("Tester");
		
		entityManager.getTransaction().commit();
		System.out.println(emp);
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}

