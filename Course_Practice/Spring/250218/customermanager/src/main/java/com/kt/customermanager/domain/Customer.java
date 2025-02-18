package com.kt.customermanager.domain;

public class Customer {
	private int id;
	private String name;
	private String gender;
	private String email;
	private int birthyear;

	public Customer() {
	}

	public Customer(int id, String name, String gender, String email, int birthyear) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.birthyear = birthyear;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}
}
