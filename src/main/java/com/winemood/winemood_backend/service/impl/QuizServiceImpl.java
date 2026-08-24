package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.request.QuizRequestDto;
import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.QuizScoreKey;
import com.winemood.winemood_backend.repository.WineRepository;
import com.winemood.winemood_backend.scoring.ScoreStrategy;
import com.winemood.winemood_backend.scoring.WineScore;
import com.winemood.winemood_backend.service.FavoriteService;
import com.winemood.winemood_backend.service.QuizResultService;
import com.winemood.winemood_backend.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    private final WineRepository wineRepository;
    private final FavoriteService favoriteService;
    private final QuizResultService quizResultService;
    private final Map<QuizScoreKey, ScoreStrategy> strategies;

    public QuizServiceImpl(
            WineRepository wineRepository,
            FavoriteService favoriteService,
            QuizResultService quizResultService,
            List<ScoreStrategy> strategyList
    ) {
        this.wineRepository = wineRepository;
        this.favoriteService = favoriteService;
        this.quizResultService = quizResultService;

        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(
                        ScoreStrategy::getKey,
                        s -> s
                ));
    }

    @Override
    public List<WineCatalogResponseDto> calculateResult(QuizRequestDto request) {
        Set<Long> favoriteWineIds = favoriteService.getFavoriteWineIds();
        Map<QuizScoreKey, String> answers = request.getAnswers();

        List<WineScore> wineScores = wineRepository.findAll().stream()
                .map(wine -> new WineScore(wine, calculateScore(wine, answers)))
                .toList();

        boolean allScoresAreZero =
                wineScores
                        .stream()
                        .allMatch(wineScore -> wineScore.score() == 0);

        List<Wine> resultWines;

        if (allScoresAreZero) {
            resultWines = wineRepository.findRandomFour();

        } else {
            resultWines = wineScores.stream()
                    .sorted(Comparator.comparingInt(WineScore::score).reversed())
                    .limit(4)
                    .map(WineScore::wine)
                    .toList();
        }

        quizResultService.saveQuizResult(
                resultWines.stream()
                        .map(Wine::getId)
                        .toList(),
                answers
        );

        return resultWines.stream()
                .map(wine -> favoriteService.toCatalogDtoWithFavorite(
                        wine,
                        favoriteWineIds
                ))
                .toList();
    }

    private int calculateScore(Wine wine, Map<QuizScoreKey, String> answers) {

        int score = 0;

        for (Map.Entry<QuizScoreKey, String> entry : answers.entrySet()) {
            ScoreStrategy strategy = strategies.get(entry.getKey());

            if (strategy == null) continue;

            score += strategy.score(wine, entry.getValue());
        }

        return score;
    }
}