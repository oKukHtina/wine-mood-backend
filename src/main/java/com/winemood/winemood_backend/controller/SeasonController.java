package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.SeasonResponseDto;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.service.SeasonService;
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
@RequestMapping("/api/seasons")
@Tag(name = "Seasons", description = "Endpoints for managing seasons")
public class SeasonController {
    private final SeasonService service;

    @Operation(summary = "Get seasons", description = "Returns a list of all seasons")
    @ApiResponse(responseCode = "200", description = "Seasons successfully retrieved")
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    @GetMapping
    public List<SeasonResponseDto> getAllSeasons() {
        return service.getAllSeasons();
    }
}
