package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.AnalyticsEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalyticsEventRepository extends JpaRepository<AnalyticsEvent, Long> {
}
