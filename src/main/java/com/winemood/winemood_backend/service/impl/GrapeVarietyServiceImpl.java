package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.GrapeVarietiesResponseDto;
import com.winemood.winemood_backend.mapper.GrapeVarietyMapper;
import com.winemood.winemood_backend.repository.GrapeVarietyRepository;
import com.winemood.winemood_backend.service.GrapeVarietyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrapeVarietyServiceImpl implements GrapeVarietyService {
    private final GrapeVarietyRepository repository;
    private final GrapeVarietyMapper mapper;

    @Override
    public List<GrapeVarietiesResponseDto> getAllGrapeVarieties() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
