package com.winemood.winemood_backend.scoring;

import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.QuizScoreKey;

public interface ScoreStrategy {
    QuizScoreKey getKey();
    int score(Wine wine, String answer);
}
