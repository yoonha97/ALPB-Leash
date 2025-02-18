package com.kt.customermanager.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kt.customermanager.domain.Customer;
import com.kt.customermanager.domain.CustomerRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CustomerController {

	private CustomerRepository repository = new CustomerRepository();

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		List<Customer> customers = repository.findAll();
		return customers;
	}

	@GetMapping("/customers/{id}")
	public Customer customerDetail(@PathVariable("id") int id) {
		Customer customer = repository.findById(id);
		return customer;
	}
}