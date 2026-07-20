package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.dto.response.WineResponseDto;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.mapper.WineMapper;
import com.winemood.winemood_backend.repository.UserRepository;
import com.winemood.winemood_backend.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final UserRepository userRepository;
    private final WineMapper mapper;

    @Override
    public Set<Long> getFavoriteWineIds() {
        User user = getAuthenticatedUser();

        if (user == null) {
            return Set.of();
        }

        return user.getFavoriteWines()
                .stream()
                .map(Wine::getId)
                .collect(Collectors.toSet());
    }

    @Override
    public WineCatalogResponseDto toCatalogDto(
            Wine wine,
            Set<Long> favoriteWineIds
    ) {
        WineCatalogResponseDto dto = mapper.toCatalogDto(wine);
        dto.setFavorite(favoriteWineIds.contains(wine.getId()));
        return dto;
    }

    @Override
    public WineResponseDto toDto(
            Wine wine,
            Set<Long> favoriteWineIds
    ) {
        WineResponseDto dto = mapper.toDto(wine);
        dto.setFavorite(favoriteWineIds.contains(wine.getId()));
        return dto;
    }

    private User getAuthenticatedUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null
                || !authentication.isAuthenticated()
                || !(authentication.getPrincipal() instanceof UserDetails userDetails)) {
            return null;
        }

        return userRepository.findByEmail(userDetails.getUsername())
                .orElse(null);
    }
}
