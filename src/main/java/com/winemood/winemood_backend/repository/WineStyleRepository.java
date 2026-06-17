package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.WineStyle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineStyleRepository extends JpaRepository<WineStyle, Long> {
}
