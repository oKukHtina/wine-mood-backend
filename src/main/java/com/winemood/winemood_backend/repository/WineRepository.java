package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Category;
import com.winemood.winemood_backend.entity.Wine;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
}
