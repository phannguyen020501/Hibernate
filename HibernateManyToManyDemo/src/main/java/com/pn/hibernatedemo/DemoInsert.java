package com.pn.hibernatedemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pn.hibernatedemo.entities.Category;
import com.pn.hibernatedemo.entities.Product;


public class DemoInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Category category = new Category();
		category.setName("Electric Device");
		Product product1 = new Product("Television");
		Product product2 = new Product("Iphone");
		Product product3 = new Product("Samsung galaxy");

		
		Set<Product> products = new HashSet<Product>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		category.setProducts(products);
		
		entityManager.persist(category);
		entityManager.getTransaction().commit();
		
		System.out.println(category);
		System.out.println(product1);
		System.out.println(product2);
		System.out.println(product3);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
