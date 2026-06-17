package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.MoodResponseDto;
import com.winemood.winemood_backend.mapper.MoodMapper;
import com.winemood.winemood_backend.repository.MoodRepository;
import com.winemood.winemood_backend.service.MoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoodServiceImpl implements MoodService {
    private final MoodMapper mapper;
    private final MoodRepository repository;

    @Override
    public List<MoodResponseDto> getAllMood() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
