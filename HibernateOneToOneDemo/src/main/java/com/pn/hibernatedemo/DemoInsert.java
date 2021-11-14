package com.pn.hibernatedemo;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pn.hibernatedemo.entities.Person;
import com.pn.hibernatedemo.entities.Student;


public class DemoInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Person person = new Person();
		person.setName("kai");
		person.setAddress("nghean_hanoi");
		
		Student student = new Student();
		student.setClassName("KHMT64-03");
		student.setSchoolName("HUST");
		student.setPerson(person);
		
		entityManager.persist(person);
		entityManager.persist(student);
		
		entityManager.getTransaction().commit();
		
		System.out.println("after inset");
		System.out.println(person);
		System.out.println(student);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
