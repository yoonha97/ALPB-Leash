// package com.kt.eat.service;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// import com.kt.eat.domain.MenuItemRepository;
// import com.kt.eat.domain.MenuItemRepositoryImpl;
// import com.kt.eat.domain.Restaurant;
// import com.kt.eat.domain.RestaurantRepository;
// import com.kt.eat.domain.RestaurantRepositoryImpl;

// public class RestaurantServiceTest {

// private RestaurantService restaurantService;
// private RestaurantRepository restaurantRepository;
// private MenuItemRepository menuItemRepository;

// @BeforeEach
// public void setUp() {
// restaurantRepository = new RestaurantRepositoryImpl();
// menuItemRepository = new MenuItemRepositoryImpl();
// restaurantService = new RestaurantService(restaurantRepository,
// menuItemRepository);
// }

// @Test
// @DisplayName("getRestaurant 메서드 상세보기 테스트")
// void testGetRestaurant() {
// // setUp();
// // assertEquals(restaurantService.getRestaurant(1L), null);
// Restaurant restaurant = restaurantService.getRestaurant(1L);
// assertEquals(restaurant.getId(), 1L);
// assertEquals(restaurant.getMenuItems().get(0).getName(), "Kimchi");
// }

// @Test
// @DisplayName("getRestaurant 메서드 목록보기 테스트")
// void testGetRestaurants() {
// List<Restaurant> restaurants = restaurantService.getRestaurants();
// assertEquals(restaurants.get(0).getId(), 1L);
// }
// }
