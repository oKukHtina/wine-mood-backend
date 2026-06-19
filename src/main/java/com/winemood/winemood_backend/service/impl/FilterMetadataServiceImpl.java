package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.FilterMetadataResponseDto;
import com.winemood.winemood_backend.filter.options.FilterOptionProvider;
import com.winemood.winemood_backend.mapper.FilterMetadataMapper;
import com.winemood.winemood_backend.repository.FilterMetadataRepository;
import com.winemood.winemood_backend.service.FilterMetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterMetadataServiceImpl implements FilterMetadataService {
    private final List<FilterOptionProvider> providers;

    private final FilterMetadataRepository repository;
    private final FilterMetadataMapper mapper;

    @Override
    public List<FilterMetadataResponseDto> getAllFilters() {
        return repository.findAll()
                .stream()
                .map(meta -> {
                    FilterMetadataResponseDto dto = mapper.toDto(meta);

                    providers.stream()
                            .filter(p -> p.getKey() == meta.getFilterKey())
                            .findFirst()
                            .ifPresent(p -> dto.setOptions(p.getOptions()));
                    return dto;
                })
                .toList();
    }
}
