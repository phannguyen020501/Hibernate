package com.pn.hibernatedemo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@EmbeddedId
	private Pk pk;
	
	@Column(name = "address")
	private String address;

	public Pk getPk() {
		return pk;
	}

	public void setPk(Pk pk) {
		this.pk = pk;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee() {
		super();
	}

	public Employee(Pk pk, String address) {
		super();
		this.pk = pk;
		this.address = address;
	}

	public Employee(String address) {
		super();
		this.address = address;
	}
	
	@Embeddable
	public static class Pk implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Column(name = "first_name")
		private String firstName;
		
		@Column(name = "last_name")
		private String lastName;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Pk [firstName = "+ firstName + ", lastName = " + lastName +"]";
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Pk(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public Pk() {
			super();
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee [pk = " + pk + ", address = " + address + "]";
	}
	
}
