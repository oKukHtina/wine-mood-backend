package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.entity.WineViewHistory;
import com.winemood.winemood_backend.repository.WineViewHistoryRepository;
import com.winemood.winemood_backend.service.DiscoveryAchievementService;
import com.winemood.winemood_backend.service.WineViewHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WineViewHistoryServiceImpl implements WineViewHistoryService {
    private final WineViewHistoryRepository wineViewHistoryRepository;
    private final DiscoveryAchievementService discoveryAchievementService;

    @Override
    @Transactional
    public void saveView(User user, Wine wine) {
        if (wineViewHistoryRepository.existsByUserAndWine(user, wine)) {
            return;
        }

        WineViewHistory history = new WineViewHistory();
        history.setUser(user);
        history.setWine(wine);
        history.setViewedAt(LocalDateTime.now());

        wineViewHistoryRepository.save(history);
        discoveryAchievementService.handleWineView(user, wine);
    }
}
