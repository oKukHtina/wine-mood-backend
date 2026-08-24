package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.QuizResultResponseDto;
import com.winemood.winemood_backend.enums.QuizScoreKey;

import java.util.List;
import java.util.Map;

public interface QuizResultService {
    void saveQuizResult(
            List<Long> wineIds,
            Map<QuizScoreKey, String> answers
    );

    void saveQuizResult(List<Long> wineIds);

    List<QuizResultResponseDto> getQuizHistory();
}
