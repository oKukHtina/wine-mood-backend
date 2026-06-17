package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
