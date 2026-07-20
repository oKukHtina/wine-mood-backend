package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.dto.response.WineResponseDto;
import com.winemood.winemood_backend.entity.Wine;

import java.util.Set;

public interface FavoriteService {

    Set<Long> getFavoriteWineIds();

    WineCatalogResponseDto toCatalogDto(Wine wine, Set<Long> favoriteWineIds);

    WineResponseDto toDto(Wine wine, Set<Long> favoriteWineIds);
}