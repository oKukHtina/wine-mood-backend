package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.Achievement;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.UserAchievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, Long> {
    boolean existsByUserAndAchievement(User user, Achievement achievement);
    List<UserAchievement> findAllByUserOrderByEarnedAtDesc(User user);
}
