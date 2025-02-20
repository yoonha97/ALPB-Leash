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
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	public MenuItemService(MenuItemRepository menuItemRepository, RestaurantRepository restaurantRepository) {
		this.menuItemRepository = menuItemRepository;
		this.restaurantRepository = restaurantRepository;
	}

	public List<MenuItem> getMenuItems(Long restaurantId) {
		return menuItemRepository.findAllByRestaurantId(restaurantId);
	}

	public MenuItem getMenuItem(Long id) {
		return menuItemRepository.findById(id).orElse(null);
	}

	@Transactional
	public MenuItem addMenuItem(Long restaurantId, String name) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
				() -> new IllegalArgumentException("존재하지 않는 레스토랑입니다."));

		MenuItem menuItem = MenuItem.builder()
				.name(name)
				.restaurant(restaurant)
				.build();

		restaurant.addMenuItem(menuItem); // ★ Restaurant 엔터티에도 추가 ★

		return menuItemRepository.save(menuItem);
	}

	@Transactional
	public void updateMenuItem(Long id, String name) {
		MenuItem menuItem = menuItemRepository.findById(id).orElse(null);
		if (menuItem != null) {
			menuItem.setName(name);
		}
	}

	public void deleteMenuItem(Long id) {
		menuItemRepository.deleteById(id);
	}
}
