package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Long> {
}
