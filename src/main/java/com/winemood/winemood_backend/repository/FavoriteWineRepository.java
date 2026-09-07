package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.FavoriteWine;
import com.winemood.winemood_backend.entity.FavoriteWineId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteWineRepository extends JpaRepository<FavoriteWine, FavoriteWineId> {
    List<FavoriteWine> findByUserIdOrderByCreatedAtDesc(Long userId);
}
