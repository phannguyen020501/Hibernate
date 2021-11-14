package com.pn.hibernatedemo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="company")
public class Company {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private Set<Employee> listEmployee = new HashSet<Employee>();

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(Set<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}
	
	
	public Company(int id, String name, String address, Set<Employee> listEmployee) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.listEmployee = listEmployee;
	}
	public Company() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Company [id ="+ id+", name = "+name+"]";
	}

}
