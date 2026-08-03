package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.QuizResultResponseDto;
import com.winemood.winemood_backend.entity.QuizResult;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.AchievementCode;
import com.winemood.winemood_backend.repository.QuizResultRepository;
import com.winemood.winemood_backend.repository.WineRepository;
import com.winemood.winemood_backend.service.AchievementService;
import com.winemood.winemood_backend.service.AuthenticatedUserService;
import com.winemood.winemood_backend.service.FavoriteService;
import com.winemood.winemood_backend.service.QuizResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    private final WineRepository wineRepository;
    private final AuthenticatedUserService authenticatedUserService;
    private final AchievementService achievementService;
    private final FavoriteService favoriteService;

    @Override
    public void saveQuizResult(List<Long> wineIds) {
        User currentUser = authenticatedUserService.getCurrentUserOrNull();

        if (currentUser == null) {
            return;
        }

        Map<Long, Wine> wineMap = wineRepository.findAllById(wineIds)
                .stream()
                .collect(Collectors.toMap(Wine::getId, Function.identity()));

        List<Wine> wines = wineIds.stream()
                .map(wineMap::get)
                .toList();

        QuizResult quizResult = new QuizResult();
        quizResult.setUser(currentUser);
        quizResult.setCreatedAt(LocalDateTime.now());
        quizResult.setWines(wines);

        quizResultRepository.save(quizResult);

        achievementService.grantAchievement(
                currentUser,
                AchievementCode.FIRST_QUIZ
        );
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
