package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.SweetnessLevelResponseDto;
import com.winemood.winemood_backend.mapper.SweetnessLevelMapper;
import com.winemood.winemood_backend.repository.SweetnessLevelRepository;
import com.winemood.winemood_backend.service.SweetnessLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SweetnessLevelServiceImpl implements SweetnessLevelService {
    private final SweetnessLevelMapper mapper;
    private final SweetnessLevelRepository repository;

    @Override
    public List<SweetnessLevelResponseDto> getAllSweetnessLevel() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
