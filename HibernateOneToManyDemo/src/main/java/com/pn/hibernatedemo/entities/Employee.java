package com.pn.hibernatedemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employee(int id, String name, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}

	public Employee(String name, Company company) {
		super();
		this.name = name;
		this.company = company;
	}

	public Employee() {
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee[id =" + id+ ", name = "+name+", company = "+company+"]";
	}

}
