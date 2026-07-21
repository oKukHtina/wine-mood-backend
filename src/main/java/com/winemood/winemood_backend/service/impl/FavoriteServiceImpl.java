package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.dto.response.WineResponseDto;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.mapper.WineMapper;
import com.winemood.winemood_backend.service.AuthenticatedUserService;
import com.winemood.winemood_backend.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private final AuthenticatedUserService authenticatedUserService;
    private final WineMapper mapper;

    @Override
    public Set<Long> getFavoriteWineIds() {
        User user = authenticatedUserService.getCurrentUserOrNull();

        if (user == null) {
            return Set.of();
        }

        return user.getFavoriteWines()
                .stream()
                .map(Wine::getId)
                .collect(Collectors.toSet());
    }

    @Override
    public WineCatalogResponseDto toCatalogDtoWithFavorite(
            Wine wine,
            Set<Long> favoriteWineIds
    ) {
        WineCatalogResponseDto dto = mapper.toCatalogDto(wine);
        dto.setFavorite(favoriteWineIds.contains(wine.getId()));
        return dto;
    }

    @Override
    public WineResponseDto toDtoWithFavorite(
            Wine wine,
            Set<Long> favoriteWineIds
    ) {
        WineResponseDto dto = mapper.toDto(wine);
        dto.setFavorite(favoriteWineIds.contains(wine.getId()));
        return dto;
    }
}
