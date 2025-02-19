package com.kt.customermanager.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AllergicFoodRepositoryImpl implements AllergicFoodRepository {
	private List<AllergicFood> allergicFoods = new ArrayList<>();

	public AllergicFoodRepositoryImpl() {
		allergicFoods.add(new AllergicFood("Peanut"));
	}

	@Override
	public List<AllergicFood> findAllergicFoodsById(int id) {
		return allergicFoods;
	}
}