package com.winemood.winemood_backend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Achievement unlocked by the user")
public record AchievementResponseDto(
        @Schema(
                description = "Unique achievement code",
                example = "FIRST_WINE"
        )
        String code,

        @Schema(
                description = "Achievement title",
                example = "First Sip"
        )
        String title,

        @Schema(
                description = "Achievement description",
                example = "View your first wine."
        )
        String description,

        @Schema(
                description = "URL of the achievement icon",
                example = "https://res.cloudinary.com/demo/image/upload/achievements/first_wine.png"
        )
        String iconUrl,

        @Schema(
                description = "Date and time when the achievement was unlocked",
                example = "2026-08-03T14:20:15"
        )
        LocalDateTime unlockedAt
) {
}
