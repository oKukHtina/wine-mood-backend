package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Review;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByWineOrderByCreatedAtDesc(Wine wine);

    List<Review> findAllByUserOrderByCreatedAtDesc(User user);

    Optional<Review> findByUserAndWine(User user, Wine wine);

    @Query("""
            SELECT AVG(r.rating)
            FROM Review r
            WHERE r.wine = :wine""")
    BigDecimal findAverageRatingByWine(Wine wine);
}
