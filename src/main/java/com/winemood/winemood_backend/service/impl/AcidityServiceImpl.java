package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.AcidityResponseDto;
import com.winemood.winemood_backend.mapper.AcidityMapper;
import com.winemood.winemood_backend.repository.AcidityRepository;
import com.winemood.winemood_backend.service.AcidityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcidityServiceImpl implements AcidityService {

    private final AcidityRepository repository;
    private final AcidityMapper mapper;

    @Override
    public List<AcidityResponseDto> getAllAcidity() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
