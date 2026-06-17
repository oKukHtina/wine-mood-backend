package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Acidity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcidityRepository extends JpaRepository<Acidity, Long> {
}
