package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.QuizResultResponseDto;
import java.util.List;

public interface QuizResultService {
    void saveQuizResult(List<Long> wineIds);

    List<QuizResultResponseDto> getQuizHistory();
}
