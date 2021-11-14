package com.pn.hibernateentitymanager;

import java.util.List;
import java.util.function.Consumer;

import com.pn.hibernateentitymanager.dao.CustomerDAO;
import com.pn.hibernateentitymanager.entities.Customer;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAO();
		//customerDAO.save(new Customer("kai","Vietnam"));
		//customerDAO.save(new Customer("Thanos", "Vietnam"));
		List<Customer> listCustomer = customerDAO.findAll();
		listCustomer.forEach(new Consumer<Customer>() {
			public void accept(Customer c) {
				System.out.println(c.getName());
			}
		});
		customerDAO.close();

	}

}
