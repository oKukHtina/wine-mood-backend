package com.winemood.winemood_backend.scoring.impl;

import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.QuizScoreKey;
import com.winemood.winemood_backend.scoring.ScoreStrategy;
import org.springframework.stereotype.Component;

@Component
public class AromaNoteScoreStrategy implements ScoreStrategy {
    @Override
    public QuizScoreKey getKey() {
        return QuizScoreKey.AROMA_NOTES;
    }

    @Override
    public int score(Wine wine, String answer) {
        return wine
                .getTasteProfile()
                .getAromaNotes()
                .stream()
                .anyMatch(aroma -> aroma.getName().equals(answer)) ? 6 : 0;
    }
}
