package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.AromaNoteResponseDto;

import java.util.List;

public interface AromaNoteService {
    List<AromaNoteResponseDto> getAllAromaNote();
}
