package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.FilterMetadata;
import com.winemood.winemood_backend.enums.FilterKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilterMetadataRepository extends JpaRepository<FilterMetadata, FilterKey> {
}
