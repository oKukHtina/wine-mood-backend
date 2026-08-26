package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.asset.*;
import com.winemood.winemood_backend.service.AssetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
@Tag(
        name = "Assets",
        description = "Endpoints for retrieving website decorative and history assets"
)
public class AssetController {
    private final AssetService assetService;

    @GetMapping("/moods")
    @Operation(
            summary = "Get mood assets",
            description = "Returns images associated with wine moods."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Mood assets successfully retrieved"
    )
    public List<MoodAssetResponseDto> getMoods() {
        return assetService.getMoods();
    }

    @GetMapping("/history/woman")
    @Operation(
            summary = "Get history woman images",
            description = "Returns the history page woman images for different moods and situations."
    )
    @ApiResponse(
            responseCode = "200",
            description = "History woman images successfully retrieved"
    )
    public HistoryWomanResponseDto getHistoryWoman() {
        return assetService.getHistoryWoman();
    }

    @GetMapping("/history/origins")
    @Operation(
            summary = "Get wine history origins",
            description = "Returns the content and images for the origins section of the wine history page."
    )
    @ApiResponse(
            responseCode = "200",
            description = "History origins successfully retrieved"
    )
    public List<HistoryOriginResponseDto> getOrigins() {
        return assetService.getOrigins();
    }

    @GetMapping("/history/timeline")
    @Operation(
            summary = "Get wine history timeline",
            description = "Returns the timeline entries and images for the wine history page."
    )
    @ApiResponse(
            responseCode = "200",
            description = "History timeline successfully retrieved"
    )
    public List<HistoryTimelineResponseDto> getTimeline() {
        return assetService.getTimeline();
    }

    @GetMapping("/site")
    @Operation(
            summary = "Get site assets",
            description = "Returns decorative assets used across different website sections."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Site assets successfully retrieved"
    )
    public SiteAssetsResponseDto getSiteAssets() {
        return assetService.getSiteAssets();
    }
}
