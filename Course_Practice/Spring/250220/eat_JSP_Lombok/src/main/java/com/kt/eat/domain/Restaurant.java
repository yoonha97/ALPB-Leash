package com.kt.eat.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;

// import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

	private String name;

	private String address;

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<MenuItem> menuItems = new ArrayList<>();

	// 삭제 플래그
	// @Transient
	// @JsonInclude(JsonInclude.Include.NON_DEFAULT)
	// private boolean destroy;

	public String getInformation() {
		return name + " in " + address;
	}

	public void addMenuItem(MenuItem menuItem) {
		menuItems.add(menuItem);
		menuItem.setRestaurant(this);
	}
}
