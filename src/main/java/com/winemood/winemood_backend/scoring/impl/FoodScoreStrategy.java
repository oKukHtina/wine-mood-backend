package com.winemood.winemood_backend.scoring.impl;

import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.QuizScoreKey;
import com.winemood.winemood_backend.scoring.ScoreStrategy;
import org.springframework.stereotype.Component;

@Component
public class FoodScoreStrategy implements ScoreStrategy {
    @Override
    public QuizScoreKey getKey() {
        return QuizScoreKey.FOOD_CATEGORY;
    }

    @Override
    public int score(Wine wine, String answer) {
        if (answer == null) {
            return 0;
        }
        return wine
                .getFoodPairings()
                .stream()
                .anyMatch(event -> event.getName().equals(answer)) ? 7 : 3;
    }
}
