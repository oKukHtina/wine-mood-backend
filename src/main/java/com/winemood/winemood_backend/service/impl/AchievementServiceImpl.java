package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.AchievementResponseDto;
import com.winemood.winemood_backend.entity.Achievement;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.UserAchievement;
import com.winemood.winemood_backend.enums.AchievementCode;
import com.winemood.winemood_backend.exceptions.AchievementNotFoundException;
import com.winemood.winemood_backend.mapper.AchievementMapper;
import com.winemood.winemood_backend.repository.AchievementRepository;
import com.winemood.winemood_backend.repository.UserAchievementRepository;
import com.winemood.winemood_backend.service.AchievementService;
import com.winemood.winemood_backend.service.AuthenticatedUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {
    private final AchievementRepository achievementRepository;
    private final UserAchievementRepository userAchievementRepository;
    private final AchievementMapper achievementMapper;
    private final AuthenticatedUserService authenticatedUserService;

    @Transactional
    @Override
    public void grantAchievement(User user, AchievementCode achievementCode) {
        Achievement achievement = achievementRepository.findByCode(achievementCode.name())
                .orElseThrow(
                        () -> new AchievementNotFoundException(achievementCode.name())
                );

        if (userAchievementRepository.existsByUserAndAchievement(user, achievement)) {
            return;
        }

        UserAchievement userAchievement = new UserAchievement();
        userAchievement.setUser(user);
        userAchievement.setAchievement(achievement);
        userAchievement.setEarnedAt(LocalDateTime.now());

        userAchievementRepository.save(userAchievement);
    }

    @Override
    public List<AchievementResponseDto> getCurrentUserAchievements() {
        User currentUser = authenticatedUserService.getCurrentUser();

        return userAchievementRepository
                .findAllByUserOrderByEarnedAtDesc(currentUser)
                .stream()
                .map(achievementMapper::toDto)
                .toList();
    }
}
