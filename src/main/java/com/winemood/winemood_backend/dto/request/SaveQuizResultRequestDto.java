package com.winemood.winemood_backend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Request for saving a quiz result")
public record SaveQuizResultRequestDto(
        @Schema(
                description = "IDs of the four wines returned by the quiz",
                example = "[12, 45, 78, 91]",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        List<Long> wineIds
) {
}
