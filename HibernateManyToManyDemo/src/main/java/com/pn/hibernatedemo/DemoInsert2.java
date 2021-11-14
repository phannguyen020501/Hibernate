package com.pn.hibernatedemo;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pn.hibernatedemo.entities.Category;
import com.pn.hibernatedemo.entities.Product;


public class DemoInsert2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Category category = new Category();
		category.setName("Home Application");
		
		Product product = entityManager.find(Product.class, 2);
		
		product.getCategories().add(category);
		
		entityManager.getTransaction().commit();
		System.out.println("after insert");
		System.out.println(category);
		System.out.println(product);
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}

