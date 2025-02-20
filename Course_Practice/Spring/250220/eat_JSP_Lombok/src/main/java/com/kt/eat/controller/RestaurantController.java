package com.kt.eat.controller;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kt.eat.domain.Restaurant;
import com.kt.eat.service.RestaurantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("/restaurants")
	public List<Restaurant> restaurants() {
		List<Restaurant> restaurants = restaurantService.getRestaurants();
		return restaurants;
	}

	@GetMapping("/restaurants/{id}")
	public Restaurant restaurantDetail(@PathVariable("id") Long id) {
		Restaurant restaurant = restaurantService.getRestaurant(id);
		return restaurant;
	}

	@PostMapping("/restaurants")
	public ResponseEntity<?> create(@RequestBody Restaurant resource) {
		String name = resource.getName();
		String address = resource.getAddress();
		Restaurant restaurant = restaurantService
				.addRestaurant(Restaurant.builder().name(name).address(address).build());
		URI location = URI.create("/restaurants/" + restaurant.getId());
		return ResponseEntity.created(location).body("{}");
	}

	@PatchMapping("/restaurants/{id}")
	public String update(@PathVariable("id") Long id, @RequestBody Restaurant resource) {
		String name = resource.getName();
		String address = resource.getAddress();
		restaurantService.updateRestaurant(id, name, address);
		return "{}";
	}

	@DeleteMapping("/restaurants/{id}")
	public String delete(@PathVariable("id") Long id) {
		restaurantService.deleteRestaurant(id);
		return "{}";
	}
}
