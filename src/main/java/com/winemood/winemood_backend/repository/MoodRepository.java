package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Mood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodRepository extends JpaRepository<Mood, Long> {
}
