package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.SweetnessLevelResponseDto;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.service.SweetnessLevelService;
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
@RequestMapping("/api/sweetnessLevel")
@Tag(name = "Sweetness_level", description = "Endpoints for managing wine sweetness level")
public class SweetnessLevelController {
    private final SweetnessLevelService service;

    @Operation(summary = "Get sweetness level", description = "Returns a list of all wine sweetness levels")
    @ApiResponse(responseCode = "200", description = "Sweetness level successfully retrieved")
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    @GetMapping
    public List<SweetnessLevelResponseDto> getAllSweetnessLevel() {
        return service.getAllSweetnessLevel();
    }

}
