package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.AromaNoteResponseDto;
import com.winemood.winemood_backend.mapper.AromaNoteMapper;
import com.winemood.winemood_backend.repository.AromaNoteRepository;
import com.winemood.winemood_backend.service.AromaNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AromaNoteServiceImpl implements AromaNoteService {
    private final AromaNoteRepository repository;
    private final AromaNoteMapper mapper;

    @Override
    public List<AromaNoteResponseDto> getAllAromaNote() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
