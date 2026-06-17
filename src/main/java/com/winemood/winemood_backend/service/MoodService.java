package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.MoodResponseDto;

import java.util.List;

public interface MoodService {
    List<MoodResponseDto> getAllMood();
}
