package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.EventResponseDto;
import java.util.List;

public interface EventService {
    List<EventResponseDto> getAllEvents();
}
