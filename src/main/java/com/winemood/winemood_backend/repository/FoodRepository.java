package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByFoodCategory(String foodCategory);

    List<Food> findByName(String name);
}
