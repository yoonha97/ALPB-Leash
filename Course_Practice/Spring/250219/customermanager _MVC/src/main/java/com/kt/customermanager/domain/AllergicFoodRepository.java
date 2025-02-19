package com.kt.customermanager.domain;

import java.util.List;

public interface AllergicFoodRepository {
	List<AllergicFood> findAllergicFoodsById(int id);
}
