package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.QuizResultResponseDto;
import com.winemood.winemood_backend.entity.QuizResult;
import com.winemood.winemood_backend.entity.QuizResultAnswer;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.AchievementCode;
import com.winemood.winemood_backend.enums.QuizScoreKey;
import com.winemood.winemood_backend.repository.QuizResultAnswerRepository;
import com.winemood.winemood_backend.repository.QuizResultRepository;
import com.winemood.winemood_backend.repository.WineRepository;
import com.winemood.winemood_backend.service.AchievementService;
import com.winemood.winemood_backend.service.AuthenticatedUserService;
import com.winemood.winemood_backend.service.FavoriteService;
import com.winemood.winemood_backend.service.QuizResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizResultServiceImpl implements QuizResultService {
    private final QuizResultRepository quizResultRepository;
    private final QuizResultAnswerRepository quizResultAnswerRepository;
    private final WineRepository wineRepository;
    private final AuthenticatedUserService authenticatedUserService;
    private final AchievementService achievementService;
    private final FavoriteService favoriteService;

    @Override
    @Transactional
    public void saveQuizResult(
            List<Long> wineIds,
            Map<QuizScoreKey, String> answers
    ) {
        User currentUser = authenticatedUserService.getCurrentUserOrNull();

        if (currentUser == null) {
            return;
        }

        QuizResult quizResult = createQuizResult(currentUser, wineIds);

        List<QuizResultAnswer> resultAnswers = answers.entrySet()
                .stream()
                .map(entry -> {
                    QuizResultAnswer answer = new QuizResultAnswer();
                    answer.setQuizResult(quizResult);
                    answer.setAnswerKey(entry.getKey().name());
                    answer.setAnswerValue(entry.getValue());
                    return answer;
                })
                .toList();

        quizResultAnswerRepository.saveAll(resultAnswers);

        achievementService.grantAchievement(
                currentUser,
                AchievementCode.FIRST_QUIZ
        );
    }

    @Override
    @Transactional
    public void saveQuizResult(List<Long> wineIds) {
        User currentUser = authenticatedUserService.getCurrentUserOrNull();

        if (currentUser == null) {
            return;
        }

        createQuizResult(currentUser, wineIds);

        achievementService.grantAchievement(
                currentUser,
                AchievementCode.FIRST_QUIZ
        );
    }

    private QuizResult createQuizResult(
            User currentUser,
            List<Long> wineIds
    ) {
        Map<Long, Wine> wineMap = wineRepository.findAllById(wineIds)
                .stream()
                .collect(Collectors.toMap(
                        Wine::getId,
                        Function.identity()
                ));

        List<Wine> wines = wineIds.stream()
                .map(wineMap::get)
                .toList();

        QuizResult quizResult = new QuizResult();
        quizResult.setUser(currentUser);
        quizResult.setCreatedAt(LocalDateTime.now());
        quizResult.setWines(wines);

        return quizResultRepository.save(quizResult);
    }

    @Override
    public List<QuizResultResponseDto> getQuizHistory() {
        User currentUser = authenticatedUserService.getCurrentUser();

        Set<Long> favoriteWineIds = favoriteService.getFavoriteWineIds();

        return quizResultRepository
                .findAllByUserOrderByCreatedAtDesc(currentUser)
                .stream()
                .map(quizResult -> new QuizResultResponseDto(
                        quizResult.getId(),
                        quizResult.getCreatedAt(),
                        quizResult.getWines()
                                .stream()
                                .map(wine -> favoriteService.toCatalogDtoWithFavorite(
                                        wine,
                                        favoriteWineIds
                                ))
                                .toList()
                ))
                .toList();
    }
}
