package com.pn.hibernatedemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pn.hibernatedemo.entities.Category;
import com.pn.hibernatedemo.entities.Product;

public class DemoSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	
		Category category = entityManager.find(Category.class, 1);
		System.out.println(category);
		category.getProducts().forEach(p -> System.out.println(p));
		
		System.out.println("------------------------");
		Product product = entityManager.find(Product.class, 2);
		System.out.println(product);
		product.getCategories().forEach(c -> System.out.println(c));
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
