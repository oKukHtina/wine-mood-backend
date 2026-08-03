package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.entity.Food;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.AchievementCode;
import com.winemood.winemood_backend.repository.WineViewHistoryRepository;
import com.winemood.winemood_backend.service.AchievementService;
import com.winemood.winemood_backend.service.DiscoveryAchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscoveryAchievementServiceImpl implements DiscoveryAchievementService {
    private final AchievementService achievementService;
    private final WineViewHistoryRepository wineViewHistoryRepository;

    @Override
    public void handleEventSearch(User user) {
        achievementService.grantAchievement(
                user,
                AchievementCode.EVENT_PAIRING
        );
    }

    @Override
    public void handleFoodSearch(User user, Food food) {
        achievementService.grantAchievement(
                user,
                AchievementCode.FOOD_PAIRING
        );

        if (food.getFoodCategory() != null
                && "CHEESE".equalsIgnoreCase(food.getFoodCategory().getName())) {

            achievementService.grantAchievement(
                    user,
                    AchievementCode.CHEESE_PAIRING
            );
        }
    }

    @Override
    public void handleWineView(User user, Wine wine) {
        if (wineViewHistoryRepository.countByUser(user) == 1L) {
            achievementService.grantAchievement(
                    user,
                    AchievementCode.FIRST_WINE
            );
        }

        long countries = wineViewHistoryRepository.countDistinctCountries(user);

        if (countries >= 3) {
            achievementService.grantAchievement(
                    user,
                    AchievementCode.THREE_COUNTRIES
            );
        }

        long wineTypes = wineViewHistoryRepository.countClassicWineTypes(user);

        if (wineTypes >= 3) {
            achievementService.grantAchievement(
                    user,
                    AchievementCode.THREE_WINE_TYPES
            );
        }

        long sparklingViews = wineViewHistoryRepository.countSparklingViews(user);

        if (sparklingViews > 0) {
            achievementService.grantAchievement(
                    user,
                    AchievementCode.SPARKLING_DISCOVERY
            );
        }
    }
}
