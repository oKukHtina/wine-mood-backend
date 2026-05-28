package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Food;
import com.winemood.winemood_backend.enums.FoodCategory;
import com.winemood.winemood_backend.enums.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByFoodCategory(FoodCategory foodCategory);

    List<Food> findByFoodType(FoodType foodType);
}
