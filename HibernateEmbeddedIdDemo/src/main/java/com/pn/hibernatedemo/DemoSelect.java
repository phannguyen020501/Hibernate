package com.pn.hibernatedemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pn.hibernatedemo.entities.Employee;
import com.pn.hibernatedemo.entities.Employee.Pk;

public class DemoSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee.Pk pk = new Employee.Pk();
		pk.setFirstName("phan");
		pk.setLastName("nguyen");
		
		Employee emp = entityManager.find(Employee.class, pk);
		System.out.println(emp);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
