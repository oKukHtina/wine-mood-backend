package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.WineResponseDto;
import com.winemood.winemood_backend.exceptions.WineNotFoundException;
import com.winemood.winemood_backend.mapper.WineMapper;
import com.winemood.winemood_backend.repository.WineRepository;
import com.winemood.winemood_backend.service.WineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WineServiceImpl implements WineService {
    private final WineRepository repository;
    private final WineMapper mapper;

    @Override
    public List<WineResponseDto> getAllWines() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public WineResponseDto getWineById(Long id) {
       return repository.findById(id)
               .map(mapper::toDto)
               .orElseThrow(() -> new WineNotFoundException(id));
    }
}
