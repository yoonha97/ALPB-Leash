package com.kt.eat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kt.eat.domain.MenuItem;
import com.kt.eat.domain.MenuItemRepository;
import com.kt.eat.domain.Restaurant;
import com.kt.eat.domain.RestaurantRepository;

import jakarta.transaction.Transactional;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private MenuItemRepository menuItemRepository;

	public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
		this.restaurantRepository = restaurantRepository;
		this.menuItemRepository = menuItemRepository;
	}

	public List<Restaurant> getRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurants;
	}

	public Restaurant getRestaurant(Long id) {
		Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
		List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
		restaurant.setMenuItems(menuItems);
		return restaurant;
	}

	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	// 엔터티에 정보를 변경하면 DB에도 자동으로 적용해주는 어노테이션
	@Transactional
	public void updateRestaurant(Long id, String name, String address) {
		// 1. id로 restaurant를 찾는다.
		Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
		// 2. id로 찾은 restaurant의 name과 address를 변경한다.
		restaurant.setName(name);
		restaurant.setAddress(address);
		// 3. 변경된 restaurant를 저장한다.
		// @Transactional 어노테이션을 통해 변경된 정보가 DB에 자동으로 저장된다.
	}

	public void deleteRestaurant(Long id) {
		// Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
		// destroy가 false인 경우에 삭제
		// if (!restaurant.isDestroy()) {
		restaurantRepository.deleteById(id);
		// return;
		// }
	}
}
