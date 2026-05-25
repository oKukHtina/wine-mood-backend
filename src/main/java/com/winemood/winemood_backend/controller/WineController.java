package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.WineResponseDto;
import com.winemood.winemood_backend.service.WineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/wines")
@Tag(name = "Wines", description = "Endpoints for managing wine")
public class WineController {
    private final WineService wineService;

    @GetMapping
    @Operation(summary = "Get all wines", description = "Return all wines")
    @ApiResponse(
            responseCode = "200",
            description = "Wines successfully retrieved",
            content = @Content(schema = @Schema(implementation = WineResponseDto.class))
    )
    public List<WineResponseDto> getAllWines() {
        return wineService.getAllWines();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get wine by Id", description = "Returns wine by its ID")
    @ApiResponse(
            responseCode = "200",
            description = "Wine found",
            content = @Content(schema = @Schema(implementation = WineResponseDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Wine not found"
    )
    public WineResponseDto getWineById(@PathVariable Long id) {
        return wineService.getWineById(id);
    }
}
