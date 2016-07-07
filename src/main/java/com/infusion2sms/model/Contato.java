package com.infusion2sms.model;

public class Contato {
	
	private String id;
	private String firstName;
	private String lastName;
	private String phone1;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	
	@Override
	public String toString() {
		return "Contato [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phone1=" + phone1 + "]";
	}
	
	

}
