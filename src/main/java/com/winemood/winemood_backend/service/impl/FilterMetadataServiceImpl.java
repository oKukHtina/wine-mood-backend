package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.FilterMetadataResponseDto;
import com.winemood.winemood_backend.mapper.FilterMetadataMapper;
import com.winemood.winemood_backend.repository.FilterMetadataRepository;
import com.winemood.winemood_backend.service.FilterMetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterMetadataServiceImpl implements FilterMetadataService {
    private final FilterMetadataRepository repository;
    private final FilterMetadataMapper mapper;

    @Override
    public List<FilterMetadataResponseDto> getAllFilters() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
