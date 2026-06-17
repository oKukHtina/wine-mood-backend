package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.WineTasteProfileResponseDto;
import com.winemood.winemood_backend.service.WineTasteProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/wineTasteProfiles")
@Tag(name = "Taste profile", description = "Endpoints for managing wine taste profile")
public class WineTasteProfileController {
    private final WineTasteProfileService tasteProfileService;

    @GetMapping
    public List<WineTasteProfileResponseDto> getAllTasteProfiles() {
        return tasteProfileService.getAllTasteProfile();
    }

}
