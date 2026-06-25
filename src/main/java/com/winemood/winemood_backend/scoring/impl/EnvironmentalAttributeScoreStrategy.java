package com.winemood.winemood_backend.scoring.impl;

import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.QuizScoreKey;
import com.winemood.winemood_backend.scoring.ScoreStrategy;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentalAttributeScoreStrategy implements ScoreStrategy {
    @Override
    public QuizScoreKey getKey() {
        return QuizScoreKey.ENVIRONMENTAL_ATTRIBUTES;
    }

    @Override
    public int score(Wine wine, String answer) {
        return wine
                .getTasteProfile()
                .getEnvironmentalAttributes()
                .stream()
                .anyMatch(attribute -> attribute.name().equals(answer)) ? 2 : 0;
    }
}
