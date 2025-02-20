package com.kt.eat.controller;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.kt.eat.domain.MenuItem;
import com.kt.eat.service.MenuItemService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MenuItemController {

	@Autowired
	private MenuItemService menuItemService;

	@GetMapping("/restaurants/{restaurantId}/menu-items")
	public List<MenuItem> menuItems(@PathVariable("restaurantId") Long restaurantId) {
		return menuItemService.getMenuItems(restaurantId);
	}

	@GetMapping("/menu-items/{id}")
	public MenuItem menuItemDetail(@PathVariable("id") Long id) {
		return menuItemService.getMenuItem(id);
	}

	@PostMapping("/restaurants/{restaurantId}/menu-items")
	public ResponseEntity<?> create(@PathVariable("restaurantId") Long restaurantId, @RequestBody MenuItem resource) {
		MenuItem menuItem = menuItemService.addMenuItem(restaurantId, resource.getName());
		URI location = URI.create("/menu-items/" + menuItem.getId());
		return ResponseEntity.created(location).body("{}");
	}

	@PatchMapping("/menu-items/{id}")
	public String update(@PathVariable("id") Long id, @RequestBody MenuItem resource) {
		menuItemService.updateMenuItem(id, resource.getName());
		return "{}";
	}

	@DeleteMapping("/menu-items/{id}")
	public String delete(@PathVariable("id") Long id) {
		menuItemService.deleteMenuItem(id);
		return "{}";
	}
}
