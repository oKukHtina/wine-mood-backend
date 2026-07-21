package com.winemood.winemood_backend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Quiz result saved in the user's history")
public record QuizResultResponseDto(
        @Schema(
                description = "Unique quiz result identifier",
                example = "21"
        )
        Long id,

        @Schema(
                description = "Date and time when the quiz result was saved",
                example = "2026-07-23T14:35:12"
        )
        LocalDateTime createdAt,

        @Schema(
                description = "Four wines recommended by the quiz"
        )
        List<WineCatalogResponseDto> wines
) {
}
