package com.winemood.winemood_backend.scoring.impl;

import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.QuizScoreKey;
import com.winemood.winemood_backend.scoring.ScoreStrategy;
import org.springframework.stereotype.Component;

@Component
public class WineTypeScoreStrategy implements ScoreStrategy {
    @Override
    public QuizScoreKey getKey() {
        return QuizScoreKey.WINE_TYPE;
    }

    @Override
    public int score(Wine wine, String answer) {
        if (answer == null) {
            return 0;
        }
        return wine
                .getCategory()
                .getType()
                .name()
                .equals(answer) ? 8 : 0;
    }
}
