package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.WineTasteProfileResponseDto;

import java.util.List;

public interface WineTasteProfileService {
    List<WineTasteProfileResponseDto> getAllTasteProfile();
}
