package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.EventResponseDto;
import com.winemood.winemood_backend.mapper.EventMapper;
import com.winemood.winemood_backend.repository.EventRepository;
import com.winemood.winemood_backend.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository repository;
    private final EventMapper mapper;

    @Override
    public List<EventResponseDto> getAllEvents() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
