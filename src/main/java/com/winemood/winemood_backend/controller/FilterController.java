package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.FilterMetadataResponseDto;
import com.winemood.winemood_backend.dto.response.FilterOptionsResponseDto;
import com.winemood.winemood_backend.service.FilterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/filters")
@RequiredArgsConstructor
@Tag(name = "All filters", description = "Endpoints for managing all filters")
public class FilterController {
    private final FilterService filterService;

    @GetMapping
    @Operation(summary = "Get all filters", description = "Return all filters with option")
    @ApiResponse(
            responseCode = "200",
            description = "Metadata successfully retrieved",
            content = @Content(schema = @Schema(implementation = FilterMetadataResponseDto.class))
    )
    public FilterOptionsResponseDto getFilters() {
        return filterService.getFilterOptions();
    }
}
