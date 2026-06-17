package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.FilterMetadataResponseDto;
import com.winemood.winemood_backend.service.FilterMetadataService;
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
@RequestMapping("/api/metadata")
@Tag(name = "Metadata", description = "Endpoints for managing icon for filters")
public class FilterMetadataController {
    private final FilterMetadataService service;

    @GetMapping
    @Operation(summary = "Get all metadata", description = "Return all metadata")
    @ApiResponse(
            responseCode = "200",
            description = "Metadata successfully retrieved",
            content = @Content(schema = @Schema(implementation = FilterMetadataResponseDto.class))
    )
    public List<FilterMetadataResponseDto> getFilterMetadata() {
        return service.getAllFilters();
    }
}
