package com.pn.hibernatedemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pn.hibernatedemo.entities.Employee;
import com.pn.hibernatedemo.entities.Employee.Pk;

public class DemoInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Employee emp = new Employee();
		Employee.Pk pk = new Employee.Pk();
		
		pk.setFirstName("phan");
		pk.setLastName("nguyen");
		
		emp.setPk(pk);
		emp.setAddress("NgheAn-VietNam");
		
		entityManager.persist(emp);
		entityManager.getTransaction().commit();

		System.out.println(emp);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
