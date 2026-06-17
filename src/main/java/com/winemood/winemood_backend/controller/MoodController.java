package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.MoodResponseDto;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.service.MoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mood")
@Tag(name = "Mood", description = "Endpoints for managing wine mood")
public class MoodController {
    private final MoodService service;

    @Operation(summary = "Get mood", description = "Returns a list of all wine mood")
    @ApiResponse(responseCode = "200", description = "Mood successfully retrieved")
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    @GetMapping
    public List<MoodResponseDto> getAllMood() {
        return service.getAllMood();
    }
}
