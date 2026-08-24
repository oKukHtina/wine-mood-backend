package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.enums.AnalyticsEventType;

import java.util.Map;

public interface AnalyticsEventService {
    void saveEvent(
            AnalyticsEventType eventType,
            Map<String, Object> eventData
    );
}
