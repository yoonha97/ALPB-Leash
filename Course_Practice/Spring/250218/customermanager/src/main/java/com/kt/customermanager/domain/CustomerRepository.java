package com.kt.customermanager.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
	private List<Customer> customers;

	public CustomerRepository() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "김철수", "남성", "chulsu@example.com", 1990));
		customers.add(new Customer(2, "이영희", "여성", "younghee@example.com", 1985));
		customers.add(new Customer(3, "박지훈", "남성", "jihun@example.com", 1995));
	}

	public List<Customer> findAll() {
		return customers;
	}

	public Customer findById(int id) {
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		return null;
	}
}