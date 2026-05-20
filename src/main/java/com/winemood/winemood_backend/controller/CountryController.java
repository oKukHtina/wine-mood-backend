package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.CountryResponseDto;
import com.winemood.winemood_backend.service.CountryService;
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
@RequestMapping("/api/countries")
@Tag(name = "Countries", description = "Endpoints for managing wine countries")
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    @Operation(summary = "Get all countries", description = "Return all countries")
    @ApiResponse(
            responseCode = "200",
            description = "Countries successfully retrieved",
            content = @Content(schema = @Schema(implementation = CountryResponseDto.class))
    )
    public List<CountryResponseDto> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get country by Id", description = "Returns country by its ID")
    @ApiResponse(
            responseCode = "200",
            description = "Country found",
            content = @Content(schema = @Schema(implementation = CountryResponseDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Country not found"
    )
    public CountryResponseDto getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }
}
