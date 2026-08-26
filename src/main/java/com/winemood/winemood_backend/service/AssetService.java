package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.asset.*;

import java.util.List;

public interface AssetService {
    List<MoodAssetResponseDto> getMoods();

    HistoryWomanResponseDto getHistoryWoman();

    List<HistoryOriginResponseDto> getOrigins();

    List<HistoryTimelineResponseDto> getTimeline();

    SiteAssetsResponseDto getSiteAssets();
}
