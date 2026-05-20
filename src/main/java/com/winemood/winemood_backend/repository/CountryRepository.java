package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
