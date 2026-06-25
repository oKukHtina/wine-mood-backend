package com.winemood.winemood_backend.scoring;

import com.winemood.winemood_backend.entity.Wine;

public record WineScore(Wine wine, int score) {
}
