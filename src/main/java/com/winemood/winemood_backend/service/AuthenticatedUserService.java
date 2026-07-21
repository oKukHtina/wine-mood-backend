package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.entity.User;

public interface AuthenticatedUserService {
    User getCurrentUser();

    User getCurrentUserOrNull();
}
