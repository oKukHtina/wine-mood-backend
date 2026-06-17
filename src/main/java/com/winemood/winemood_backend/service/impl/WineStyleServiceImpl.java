package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.WineStyleResponseDto;
import com.winemood.winemood_backend.mapper.WineStyleMapper;
import com.winemood.winemood_backend.repository.WineStyleRepository;
import com.winemood.winemood_backend.service.WineStyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WineStyleServiceImpl implements WineStyleService {
    private final WineStyleRepository repository;
    private final WineStyleMapper mapper;

    @Override
    public List<WineStyleResponseDto> getAllWineStyle() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
