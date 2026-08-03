package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.AchievementResponseDto;
import com.winemood.winemood_backend.entity.UserAchievement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AchievementMapper {
    @Mapping(source = "achievement.code", target = "code")
    @Mapping(source = "achievement.title", target = "title")
    @Mapping(source = "achievement.description", target = "description")
    @Mapping(source = "achievement.iconUrl", target = "iconUrl")
    @Mapping(source = "earnedAt", target = "unlockedAt")
    AchievementResponseDto toDto(UserAchievement userAchievement);
}
