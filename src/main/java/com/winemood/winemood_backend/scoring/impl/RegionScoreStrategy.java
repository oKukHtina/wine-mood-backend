package com.winemood.winemood_backend.scoring.impl;

import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.QuizScoreKey;
import com.winemood.winemood_backend.scoring.ScoreStrategy;
import org.springframework.stereotype.Component;

@Component
public class RegionScoreStrategy implements ScoreStrategy {
    @Override
    public QuizScoreKey getKey() {
        return QuizScoreKey.REGION;
    }

    @Override
    public int score(Wine wine, String answer) {
        return wine
                .getProducer()
                .getRegion()
                .equals(answer) ? 5 : 2;
    }
}
