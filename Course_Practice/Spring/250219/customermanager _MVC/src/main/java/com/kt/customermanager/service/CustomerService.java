package com.kt.customermanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kt.customermanager.domain.AllergicFood;
import com.kt.customermanager.domain.AllergicFoodRepository;
import com.kt.customermanager.domain.Customer;
import com.kt.customermanager.domain.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AllergicFoodRepository allergicFoodRepository;

	public CustomerService(CustomerRepository customerRepository, AllergicFoodRepository allergicFoodRepository) {
		this.customerRepository = customerRepository;
		this.allergicFoodRepository = allergicFoodRepository;
	}

	public List<Customer> getCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	public Customer getCustomer(int id) {
		Customer customer = customerRepository.findById(id);
		if (customer == null) {
			throw new IllegalArgumentException("해당 ID의 고객을 찾을 수 없습니다");
		}
		List<AllergicFood> allergicFoods = allergicFoodRepository.findAllergicFoodsById(id);
		customer.setAllergicList(allergicFoods);
		return customer;
	}
}
