package com.kt.eat.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

	List<Restaurant> findAll();

	Optional<Restaurant> findById(Long id);

	Restaurant save(Restaurant restaurant);

}