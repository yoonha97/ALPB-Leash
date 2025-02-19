package com.kt.customermanager.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kt.customermanager.domain.Customer;
import com.kt.customermanager.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		List<Customer> customers = customerService.getCustomers();
		return customers;
	}

	@GetMapping("/customers/{id}")
	public Customer customerDetail(@PathVariable("id") int id) {
		Customer customer = customerService.getCustomer(id);
		return customer;
	}
}