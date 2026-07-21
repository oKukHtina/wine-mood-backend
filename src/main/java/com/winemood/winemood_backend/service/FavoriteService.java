package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.dto.response.WineResponseDto;
import com.winemood.winemood_backend.entity.Wine;
import java.util.Set;

public interface FavoriteService {

    Set<Long> getFavoriteWineIds();

    WineCatalogResponseDto toCatalogDtoWithFavorite(Wine wine, Set<Long> favoriteWineIds);

    WineResponseDto toDtoWithFavorite(Wine wine, Set<Long> favoriteWineIds);
}