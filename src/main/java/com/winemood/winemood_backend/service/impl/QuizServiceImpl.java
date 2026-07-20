package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.request.QuizRequestDto;
import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.QuizScoreKey;
import com.winemood.winemood_backend.mapper.WineMapper;
import com.winemood.winemood_backend.repository.WineRepository;
import com.winemood.winemood_backend.scoring.ScoreStrategy;
import com.winemood.winemood_backend.scoring.WineScore;
import com.winemood.winemood_backend.service.FavoriteService;
import com.winemood.winemood_backend.service.QuizService;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    private final WineRepository repository;
    private final FavoriteService favoriteService;
    private final Map<QuizScoreKey, ScoreStrategy> strategies;

    public QuizServiceImpl(
            WineRepository repository,
            FavoriteService favoriteService,
            List<ScoreStrategy> strategyList,
            WineMapper mapper
    ) {
        this.repository = repository;
        this.favoriteService = favoriteService;

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

        List<WineScore> wineScores = repository.findAll().stream()
                .map(wine -> new WineScore(wine, calculateScore(wine, answers)))
                .toList();

        boolean allScoresAreZero = wineScores.stream()
                .allMatch(ws -> ws.score() == 0);

        if (allScoresAreZero) {
            return repository.findRandomFour().stream()
                    .map(wine -> favoriteService.toCatalogDto(
                            wine,
                            favoriteWineIds
                    ))
                    .toList();
        }

        return wineScores.stream()
                .sorted(Comparator.comparingInt(WineScore::score).reversed())
                .limit(4)
                .map(ws -> favoriteService.toCatalogDto(
                        ws.wine(),
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