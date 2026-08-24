package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.request.WineFilterRequestDto;
import com.winemood.winemood_backend.dto.response.ApiResponseDto;
import com.winemood.winemood_backend.dto.response.Meta;
import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.dto.response.WineResponseDto;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.AnalyticsEventType;
import com.winemood.winemood_backend.exceptions.WineNotFoundException;
import com.winemood.winemood_backend.repository.FoodRepository;
import com.winemood.winemood_backend.repository.WineRepository;
import com.winemood.winemood_backend.service.*;
import com.winemood.winemood_backend.specification.WineSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;
    private final FoodRepository foodRepository;
    private final FavoriteService favoriteService;
    private final DiscoveryAchievementService discoveryAchievementService;
    private final WineViewHistoryService wineViewHistoryService;
    private final AuthenticatedUserService authenticatedUserService;
    private final AnalyticsEventService analyticsEventService;

    @Override
    public List<WineCatalogResponseDto> getAllWines(Pageable pageable) {
        Set<Long> favoriteWineIds = favoriteService.getFavoriteWineIds();

        return wineRepository.findAll(pageable)
                .stream()
                .map(
                        wine -> favoriteService.toCatalogDtoWithFavorite(
                                wine,
                                favoriteWineIds
                        )
                )
                .toList();
    }

    @Override
    public WineResponseDto getWineById(Long id) {
        Set<Long> favoriteWineIds = favoriteService.getFavoriteWineIds();
        Wine wine = getWineEntityById(id);

        User currentUser = authenticatedUserService.getCurrentUserOrNull();
        wineViewHistoryService.saveView(currentUser, wine);

        return favoriteService.toDtoWithFavorite(
                wine,
                favoriteWineIds
        );
    }

    @Override
    public List<WineCatalogResponseDto> getRecommendations(Long wineId) {
        Set<Long> favoriteWineIds = favoriteService.getFavoriteWineIds();
        Wine currentWine = getWineEntityById(wineId);

        List<Wine> recommendations = wineRepository.findRecommendations(
                currentWine.getCategory(),
                wineId,
                PageRequest.of(0, 4)
        );

        analyticsEventService.saveEvent(
                AnalyticsEventType.RECOMMENDATIONS_SHOWN,
                Map.of(
                        "wine_id", wineId,
                        "recommended_wine_ids",
                        recommendations.stream()
                                .map(Wine::getId)
                                .toList()
                )
        );

        return recommendations.stream()
                .map(wine -> favoriteService.toCatalogDtoWithFavorite(
                        wine,
                        favoriteWineIds
                ))
                .toList();
    }

    @Override
    public ApiResponseDto<List<WineCatalogResponseDto>> filterWines(WineFilterRequestDto dto, Pageable pageable) {
        Set<Long> favoriteWineIds = favoriteService.getFavoriteWineIds();
        Specification<Wine> spec = Specification.unrestricted();

        if (dto.getSearch() != null && !dto.getSearch().trim().isEmpty()) {
            spec = spec.and(
                    WineSpecification.hasName(dto.getSearch())
            );
        }

        if (dto.getWineTypes() != null && !dto.getWineTypes().isEmpty()) {
            spec = spec.and(WineSpecification.hasWineTypes(dto.getWineTypes()));
        }

        if (dto.getSweetnessLevels() != null && !dto.getSweetnessLevels().isEmpty()) {
            spec = spec.and(WineSpecification.hasSweetnessLevels(dto.getSweetnessLevels()));
        }

        if (dto.getCountries() != null && !dto.getCountries().isEmpty()) {
            spec = spec.and(WineSpecification.hasCountries(dto.getCountries()));
        }

        if (dto.getGrapeVarieties() != null && !dto.getGrapeVarieties().isEmpty()) {
            spec = spec.and(WineSpecification.hasGrapeVarieties(dto.getGrapeVarieties()));
        }

        if (dto.getWineStyles() != null && !dto.getWineStyles().isEmpty()) {
            spec = spec.and(WineSpecification.hasWineStyles(dto.getWineStyles()));
        }

        if (dto.getAcidityLevels() != null && !dto.getAcidityLevels().isEmpty()) {
            spec = spec.and(WineSpecification.hasAcidityLevels(dto.getAcidityLevels()));
        }

        if (dto.getAromaNotes() != null && !dto.getAromaNotes().isEmpty()) {
            spec = spec.and(WineSpecification.hasAromaNotes(dto.getAromaNotes()));
        }

        if (dto.getMoods() != null && !dto.getMoods().isEmpty()) {
            spec = spec.and(WineSpecification.hasMoods(dto.getMoods()));
        }

        if (dto.getEvents() != null && !dto.getEvents().isEmpty()) {
            spec = spec.and(WineSpecification.hasEvents(dto.getEvents()));
        }

        if (dto.getSeasons() != null && !dto.getSeasons().isEmpty()) {
            spec = spec.and(WineSpecification.hasSeasons(dto.getSeasons()));
        }

        if (dto.getFoodName() != null && !dto.getFoodName().isEmpty()) {
            spec = spec.and(WineSpecification.hasFoods(dto.getFoodName()));
        }

        Page<Wine> page = wineRepository.findAll(spec, pageable);

        User currentUser = authenticatedUserService.getCurrentUserOrNull();

        if (page.hasContent() && currentUser != null) {
            if (dto.getEvents() != null && !dto.getEvents().isEmpty()) {
                discoveryAchievementService.handleEventSearch(currentUser);
            }

            if (dto.getFoodName() != null
                    && !dto.getFoodName().isEmpty()) {

                dto.getFoodName().stream()
                        .map(foodRepository::findFirstByNameIgnoreCase)
                        .flatMap(Optional::stream)
                        .findFirst()
                        .ifPresent(food ->
                                discoveryAchievementService.handleFoodSearch(currentUser, food)
                        );
            }
        }

        List<WineCatalogResponseDto> data = page.getContent()
                .stream()
                .map(
                        wine -> favoriteService.toCatalogDtoWithFavorite(
                                wine,
                                favoriteWineIds
                        )
                )
                .toList();

        Meta meta = new Meta(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getSize()
        );

        return new ApiResponseDto<>(data, meta);
    }

    private Wine getWineEntityById(Long id) {
        return wineRepository.findById(id)
                .orElseThrow(() -> new WineNotFoundException(id));
    }
}
