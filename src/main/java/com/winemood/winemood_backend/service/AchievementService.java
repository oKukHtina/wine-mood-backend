package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.AchievementResponseDto;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.enums.AchievementCode;

import java.util.List;

public interface AchievementService {
    void grantAchievement(User user, AchievementCode achievementCode);
    List<AchievementResponseDto> getCurrentUserAchievements();
}