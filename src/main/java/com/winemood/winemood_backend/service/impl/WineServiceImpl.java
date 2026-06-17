package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.request.WineFilterRequestDto;
import com.winemood.winemood_backend.dto.response.ApiResponseDto;
import com.winemood.winemood_backend.dto.response.Meta;
import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.dto.response.WineResponseDto;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.exceptions.WineNotFoundException;
import com.winemood.winemood_backend.mapper.WineMapper;
import com.winemood.winemood_backend.repository.WineRepository;
import com.winemood.winemood_backend.service.WineService;
import com.winemood.winemood_backend.specification.WineSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WineServiceImpl implements WineService {
    private final WineRepository repository;
    private final WineMapper mapper;

    @Override
    public List<WineCatalogResponseDto> getAllWines(Pageable pageable) {
        return repository.findAll(pageable)
                .stream()
                .map(mapper::toCatalogDto)
                .toList();
    }

    @Override
    public WineResponseDto getWineById(Long id) {
       return repository.findById(id)
               .map(mapper::toDto)
               .orElseThrow(() -> new WineNotFoundException(id));
    }

    @Override
    public ApiResponseDto<List<WineCatalogResponseDto>> filterWines(WineFilterRequestDto dto, Pageable pageable) {
        Specification<Wine> spec = Specification.unrestricted();

        if (dto.getWineTypes() != null && !dto.getWineTypes().isEmpty()) {
            spec = spec.and(WineSpecification.hasWineTypes(dto.getWineTypes()));
        }

        if (dto.getSweetnessLevels() != null && !dto.getSweetnessLevels().isEmpty()) {
            spec = spec.and(WineSpecification.hasSweetnessLevels(dto.getSweetnessLevels()));
        }

        if (dto.getCountries() != null && !dto.getCountries().isEmpty()) {
            spec = spec.and(WineSpecification.hasCountries(dto.getCountries()));
        }

        if (dto.getGrapeVarieties() != null && !dto.getGrapeVarieties().isEmpty()) {
            spec = spec.and(WineSpecification.hasGrapeVarieties(dto.getGrapeVarieties()));
        }

        if (dto.getWineStyles() != null && !dto.getWineStyles().isEmpty()) {
            spec = spec.and(WineSpecification.hasWineStyles(dto.getWineStyles()));
        }

        if (dto.getAcidityLevels() != null && !dto.getAcidityLevels().isEmpty()) {
            spec = spec.and(WineSpecification.hasAcidityLevels(dto.getAcidityLevels()));
        }

        if (dto.getAromaNotes() != null && !dto.getAromaNotes().isEmpty()) {
            spec = spec.and(WineSpecification.hasAromaNotes(dto.getAromaNotes()));
        }

        if (dto.getMoods() != null && !dto.getMoods().isEmpty()) {
            spec = spec.and(WineSpecification.hasMoods(dto.getMoods()));
        }



        if (dto.getEvents() != null && !dto.getEvents().isEmpty()) {
            spec = spec.and(WineSpecification.hasEvents(dto.getEvents()));
        }

        if (dto.getSeasons() != null && !dto.getSeasons().isEmpty()) {
            spec = spec.and(WineSpecification.hasSeasons(dto.getSeasons()));
        }



        if (dto.getFoodName() != null && !dto.getFoodName().isEmpty()) {
            spec = spec.and(WineSpecification.hasFoods(dto.getFoodName()));
        }

        Page<Wine> page = repository.findAll(spec, pageable);

        List<WineCatalogResponseDto> data =
                page.map(mapper::toCatalogDto).getContent();

        Meta meta = new Meta(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getSize()
        );

        return new ApiResponseDto<>(data, meta);
    }
}
