package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.entity.WineViewHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WineViewHistoryRepository extends JpaRepository<WineViewHistory, Long> {
    boolean existsByUserAndWine(User user, Wine wine);

    long countByUser(User user);

    @Query("""
                SELECT COUNT(DISTINCT p.country.id)
                FROM WineViewHistory h
                JOIN h.wine w
                JOIN w.producer p
                WHERE h.user = :user
            """)
    long countDistinctCountries(User user);

    @Query("""
                SELECT COUNT(DISTINCT c.type)
                FROM WineViewHistory h
                JOIN h.wine w
                JOIN w.category c
                WHERE h.user = :user
                  AND c.type IN (
                    com.winemood.winemood_backend.enums.CategoryType.RED,
                    com.winemood.winemood_backend.enums.CategoryType.ROSE,
                    com.winemood.winemood_backend.enums.CategoryType.PREMIUM
                  )
            """)
    long countClassicWineTypes(User user);

    @Query("""
                SELECT COUNT(h)
                FROM WineViewHistory h
                WHERE h.user = :user
                  AND h.wine.category.type =
                    com.winemood.winemood_backend.enums.CategoryType.SPARKLING
            """)
    long countSparklingViews(User user);
}