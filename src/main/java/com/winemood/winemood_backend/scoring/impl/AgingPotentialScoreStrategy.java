package com.winemood.winemood_backend.scoring.impl;

import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.QuizScoreKey;
import com.winemood.winemood_backend.scoring.ScoreStrategy;
import org.springframework.stereotype.Component;

@Component
public class AgingPotentialScoreStrategy implements ScoreStrategy {
    @Override
    public QuizScoreKey getKey() {
        return QuizScoreKey.AGING_POTENTIAL;
    }

    @Override
    public int score(Wine wine, String answer) {
        return wine
                .getAgingPotential()
                .getName()
                .equals(answer) ? 4 : 2;
    }
}
