package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Category;
import com.winemood.winemood_backend.entity.Wine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface WineRepository extends JpaRepository<Wine, Long>,
        JpaSpecificationExecutor<Wine>,
        PagingAndSortingRepository<Wine, Long> {
    @Query("""
            select w
            from Wine w
            where w.category = :category
              and w.id <> :wineId
            order by function('random')
            """)
    List<Wine> findRecommendations(
            @Param("category") Category category,
            @Param("wineId") Long wineId,
            Pageable pageable
    );

    Optional<Wine> findByNameIgnoreCase(String name);

    @Query("""
            select w
            from Wine w
            where lower(w.name) like lower(concat('%', :query, '%'))
            """)
    Page<Wine> searchByName(String query, Pageable pageable);

    @Query(value = """
            SELECT *
            FROM wines
            ORDER BY RANDOM()
            LIMIT 4
            """, nativeQuery = true)
    List<Wine> findRandomFour();
}
