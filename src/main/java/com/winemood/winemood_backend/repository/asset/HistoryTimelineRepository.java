package com.winemood.winemood_backend.repository.asset;

import com.winemood.winemood_backend.entity.asset.HistoryTimeline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryTimelineRepository extends JpaRepository<HistoryTimeline, String> {
}
