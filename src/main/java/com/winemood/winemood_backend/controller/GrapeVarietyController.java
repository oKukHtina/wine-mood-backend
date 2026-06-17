package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.GrapeVarietiesResponseDto;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.service.GrapeVarietyService;
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
@RequestMapping("/api/grapeVariety")
@Tag(name = "Grape_Variety", description = "Endpoints for managing wine grape variety")
public class GrapeVarietyController {
    private final GrapeVarietyService service;

    @Operation(summary = "Get grape varieties", description = "Returns a list of all wine grape varieties")
    @ApiResponse(responseCode = "200", description = "Grape varieties successfully retrieved")
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    @GetMapping
    public List<GrapeVarietiesResponseDto> getAllVarieties() {
        return service.getAllGrapeVarieties();
    }
}
