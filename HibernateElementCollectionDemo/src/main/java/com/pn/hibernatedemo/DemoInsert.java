package com.pn.hibernatedemo;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pn.hibernatedemo.entities.Employee;

public class DemoInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Employee emp = new Employee();
		emp.setName("phanNguyen");
		entityManager.persist(emp);
		
		List<String> positions = new ArrayList<>();
		positions.add("Developer");
		positions.add("Tester");
		emp.setPositions(positions);
		
		entityManager.getTransaction().commit();
		System.out.println(emp);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
