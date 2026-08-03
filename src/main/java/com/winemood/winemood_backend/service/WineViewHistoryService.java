package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;

public interface WineViewHistoryService {
    void saveView(User user, Wine wine);
}
