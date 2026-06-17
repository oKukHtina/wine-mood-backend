package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.SeasonResponseDto;
import com.winemood.winemood_backend.mapper.SeasonMapper;
import com.winemood.winemood_backend.repository.SeasonRepository;
import com.winemood.winemood_backend.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonService {
    private final SeasonMapper mapper;
    private final SeasonRepository repository;

    @Override
    public List<SeasonResponseDto> getAllSeasons() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
