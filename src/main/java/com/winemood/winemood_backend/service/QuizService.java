package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.request.QuizRequestDto;
import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import java.util.List;

public interface QuizService {
    List<WineCatalogResponseDto> calculateResult(QuizRequestDto request);
}
