// package com.kt.eat.control;

// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.SpyBean;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.MockMvc;

// import com.kt.eat.domain.MenuItemRepository;
// import com.kt.eat.domain.MenuItemRepositoryImpl;
// import com.kt.eat.domain.RestaurantRepository;
// import com.kt.eat.domain.RestaurantRepositoryImpl;

// import static
// org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

// import static org.hamcrest.core.StringContains.containsString;

// @ExtendWith(SpringExtension.class)
// @WebMvcTest(RestaurantControl.class)
// public class RestaurantControlTest {

// @Autowired
// private MockMvc mvc;

// // Controlle에서 Autowired되는 변수를 테스트코드에서 접근할 때 설정해야 하는 내용
// @SpyBean(RestaurantRepositoryImpl.class)
// private RestaurantRepository restaurantRepository;

// @SpyBean(MenuItemRepositoryImpl.class)
// private MenuItemRepository menuItemRepository;

// @Test
// @DisplayName("RestaurantControl URL 매핑 테스트")
// void testRestaurants() throws Exception {
// mvc.perform(get("/restaurants")).andExpect(status().isOk());
// }

// @Test
// @DisplayName("RestaurantControl 리스트 정보 테스트")
// void testRestaurants2() throws Exception {
// mvc.perform(get("/restaurants"))
// .andExpect(status().isOk())
// .andExpect(content().string(containsString("Bob zip")));
// }

// @Test
// @DisplayName("RestaurantControl 상세 정보 URL 테스트")
// void testRestaurants3() throws Exception {
// mvc.perform(get("/restaurants/1"))
// .andExpect(status().isOk());
// // .andExpect(content().string(containsString("Bob zip")));
// }

// @Test
// @DisplayName("RestaurantControl 상세 정보 테스트")
// void testRestaurants4() throws Exception {
// mvc.perform(get("/restaurants/1"))
// .andExpect(status().isOk())
// .andExpect(content().string(containsString("Bob zip")))
// .andExpect(content().string(containsString("1")));
// }

// @Test
// @DisplayName("RestaurantControl 상세 정보에서 MenuItem 추가 테스트")
// void testRestaurants5() throws Exception {
// mvc.perform(get("/restaurants/1"))
// .andExpect(status().isOk())
// .andExpect(content().string(containsString("Bob zip")))
// .andExpect(content().string(containsString("1")))
// .andExpect(content().string(containsString("Kimchi")));
// }
// }
