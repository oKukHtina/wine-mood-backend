package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
