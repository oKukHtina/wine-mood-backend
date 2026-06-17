package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WineRepository extends JpaRepository<Wine, Long>, JpaSpecificationExecutor<Wine>, PagingAndSortingRepository<Wine, Long> {
}
