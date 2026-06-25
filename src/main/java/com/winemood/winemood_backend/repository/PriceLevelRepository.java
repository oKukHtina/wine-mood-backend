package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.PriceLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceLevelRepository extends JpaRepository<PriceLevel, Long> {
}
