package com.winemood.winemood_backend.repository.asset;

import com.winemood.winemood_backend.entity.asset.HistoryOrigin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryOriginRepository extends JpaRepository<HistoryOrigin, String> {
}
