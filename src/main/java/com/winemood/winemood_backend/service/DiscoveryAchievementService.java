package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.entity.Food;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;

public interface DiscoveryAchievementService {
    void handleEventSearch(User user);

    void handleFoodSearch(User user, Food food);

    void handleWineView(User user, Wine wine);
}