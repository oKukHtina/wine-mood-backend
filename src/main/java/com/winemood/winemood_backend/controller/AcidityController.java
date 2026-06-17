package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.AcidityResponseDto;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.service.AcidityService;
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
@RequestMapping("/api/acidity")
@Tag(name = "Acidity", description = "Endpoints for managing wine acidity")
public class AcidityController {
    private final AcidityService service;

    @Operation(summary = "Get all acidity", description = "Returns a list of all acidity")
    @ApiResponse(responseCode = "200", description = "Acidity successfully retrieved")
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    @GetMapping
    public List<AcidityResponseDto> getAllAcidity() {
        return service.getAllAcidity();
    }
}
