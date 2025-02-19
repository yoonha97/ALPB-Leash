package com.kt.customermanager.domain;

import java.util.List;

public interface CustomerRepository {
	List<Customer> findAll();

	Customer findById(int id);
}
