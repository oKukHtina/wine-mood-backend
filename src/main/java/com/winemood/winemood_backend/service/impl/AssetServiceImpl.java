package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.asset.*;
import com.winemood.winemood_backend.entity.asset.HistoryWomanImage;
import com.winemood.winemood_backend.entity.asset.SiteAsset;
import com.winemood.winemood_backend.repository.asset.*;
import com.winemood.winemood_backend.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {
    private final MoodAssetRepository moodAssetRepository;
    private final HistoryWomanImageRepository historyWomanImageRepository;
    private final HistoryOriginRepository historyOriginRepository;
    private final HistoryTimelineRepository historyTimelineRepository;
    private final SiteAssetRepository siteAssetRepository;

    @Override
    public List<MoodAssetResponseDto> getMoods() {
        return moodAssetRepository.findAll()
                .stream()
                .map(asset -> new MoodAssetResponseDto(
                        asset.getId(),
                        asset.getTitle(),
                        asset.getImageUrl()
                ))
                .toList();
    }

    @Override
    public HistoryWomanResponseDto getHistoryWoman() {
        Map<String, String> images = historyWomanImageRepository.findAll()
                .stream()
                .collect(Collectors.toMap(
                        HistoryWomanImage::getId,
                        HistoryWomanImage::getImageUrl
                ));

        return new HistoryWomanResponseDto(
                images.get("default"),
                images.get("cozy"),
                images.get("dateNight"),
                images.get("culinary"),
                images.get("celebration")
        );
    }

    @Override
    public List<HistoryOriginResponseDto> getOrigins() {
        return historyOriginRepository.findAll()
                .stream()
                .map(origin -> new HistoryOriginResponseDto(
                        origin.getId(),
                        origin.getTitle(),
                        origin.getDescription(),
                        origin.getImageUrl()
                ))
                .toList();
    }

    @Override
    public List<HistoryTimelineResponseDto> getTimeline() {
        return historyTimelineRepository.findAll()
                .stream()
                .map(timeline -> new HistoryTimelineResponseDto(
                        timeline.getId(),
                        timeline.getImageUrl(),
                        timeline.getText()
                ))
                .toList();
    }

    @Override
    public SiteAssetsResponseDto getSiteAssets() {
        Map<String, String> assets = siteAssetRepository.findAll()
                .stream()
                .collect(Collectors.toMap(
                        asset -> asset.getSection() + "." + asset.getAssetKey(),
                        SiteAsset::getImageUrl
                ));

        SiteAssetSectionResponseDto home =
                SiteAssetSectionResponseDto.builder()
                        .heroBackgroundUrl(assets.get("home.heroBackgroundUrl"))
                        .build();

        SiteAssetSectionResponseDto shared =
                SiteAssetSectionResponseDto.builder()
                        .pagePatternUrl(assets.get("shared.pagePatternUrl"))
                        .build();

        SiteAssetSectionResponseDto auth =
                SiteAssetSectionResponseDto.builder()
                        .backgroundUrl(assets.get("auth.backgroundUrl"))
                        .build();

        SiteAssetSectionResponseDto about =
                SiteAssetSectionResponseDto.builder()
                        .bottleImageUrl(assets.get("about.bottleImageUrl"))
                        .build();

        SiteAssetSectionResponseDto reviews =
                SiteAssetSectionResponseDto.builder()
                        .wineBackdropUrl(assets.get("reviews.wineBackdropUrl"))
                        .build();

        SiteAssetSectionResponseDto history =
                SiteAssetSectionResponseDto.builder()
                        .videoUrl(
                                assets.get("history.videoUrl")
                        )
                        .build();

        return new SiteAssetsResponseDto(
                home,
                shared,
                auth,
                about,
                reviews,
                history
        );
    }
}
