package com.winemood.winemood_backend.scoring.impl;

import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.QuizScoreKey;
import com.winemood.winemood_backend.scoring.ScoreStrategy;
import org.springframework.stereotype.Component;

@Component
public class WineStyleScoreStrategy implements ScoreStrategy {
    @Override
    public QuizScoreKey getKey() {
        return QuizScoreKey.WINE_STYLE;
    }

    @Override
    public int score(Wine wine, String answer) {
        return wine
                .getTasteProfile()
                .getWineStyle()
                .getName()
                .equals(answer) ? 5 : 1;
    }
}
