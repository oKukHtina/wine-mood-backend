package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.WineTasteProfileResponseDto;
import com.winemood.winemood_backend.mapper.WineTasteProfileMapper;
import com.winemood.winemood_backend.repository.WineTasteProfileRepository;
import com.winemood.winemood_backend.service.WineTasteProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WineTasteProfileServiceImpl implements WineTasteProfileService {
    private final WineTasteProfileRepository repository;
    private final WineTasteProfileMapper mapper;
    @Override
    public List<WineTasteProfileResponseDto> getAllTasteProfile() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
