package com.winemood.winemood_backend.scoring.impl;

import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.QuizScoreKey;
import com.winemood.winemood_backend.scoring.ScoreStrategy;
import org.springframework.stereotype.Component;

@Component
public class CountryScoreStrategy implements ScoreStrategy {
    @Override
    public QuizScoreKey getKey() {
        return QuizScoreKey.COUNTRY;
    }

    @Override
    public int score(Wine wine, String answer) {
        if (answer == null) {
            return 0;
        }

        return wine
                .getProducer()
                .getCountry()
                .getName()
                .equalsIgnoreCase(answer) ? 4 : 0;
    }
}
