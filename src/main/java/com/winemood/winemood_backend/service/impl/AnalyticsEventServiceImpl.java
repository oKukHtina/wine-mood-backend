package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.entity.AnalyticsEvent;
import com.winemood.winemood_backend.enums.AnalyticsEventType;
import com.winemood.winemood_backend.repository.AnalyticsEventRepository;
import com.winemood.winemood_backend.service.AnalyticsEventService;
import com.winemood.winemood_backend.service.AuthenticatedUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnalyticsEventServiceImpl implements AnalyticsEventService {
    private final AnalyticsEventRepository analyticsEventRepository;
    private final AuthenticatedUserService authenticatedUserService;
    private final ObjectMapper objectMapper;

    @Override
    public void saveEvent(
            String eventId,
            AnalyticsEventType eventType,
            Map<String, Object> eventData
    ) {
        if (analyticsEventRepository.existsByEventId(eventId)) {
            return;
        }

        AnalyticsEvent event = new AnalyticsEvent();

        event.setEventId(eventId);
        event.setUser(authenticatedUserService.getCurrentUserOrNull());
        event.setEventType(eventType);
        event.setCreatedAt(LocalDateTime.now());
        event.setEventData(objectMapper.writeValueAsString(eventData));

        analyticsEventRepository.save(event);
    }

    @Override
    public void saveEvent(AnalyticsEventType eventType, Map<String, Object> eventData) {
        AnalyticsEvent event = new AnalyticsEvent();

        event.setEventId(UUID.randomUUID().toString());
        event.setUser(authenticatedUserService.getCurrentUserOrNull());
        event.setEventType(eventType);
        event.setCreatedAt(LocalDateTime.now());
        event.setEventData(objectMapper.writeValueAsString(eventData));

        analyticsEventRepository.save(event);
    }
}
