package com.pn.hibernatecriteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pn.hibernatecriteria.entities.Customer;

public class DemoCriteria {
	public static void main(String[] args) {
		
		List<Customer> listCutomer = search("h", "a", null);
		for(Customer customer: listCutomer) {
			System.out.println(customer);
		}
	}
	@SuppressWarnings("unchecked")
	public static List<Customer> search(String name, String address, String desciption){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		
		Criteria criteria = session.createCriteria(Customer.class);
		if(name != null) {
			criteria.add(Restrictions.like("name", "%"+name+"%"));
		}
		if(address != null) {
			criteria.add(Restrictions.like("address","%"+address+"%"));
		}
		if(desciption != null) {
			criteria.add(Restrictions.like("desciption","%"+desciption+"%"));
		}
		
		List<Customer> result = criteria.list();
		session.close();
		sessionFactory.close();
		return result;
	}
}
