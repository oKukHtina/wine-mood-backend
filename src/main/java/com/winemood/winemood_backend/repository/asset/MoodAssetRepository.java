package com.winemood.winemood_backend.repository.asset;

import com.winemood.winemood_backend.entity.asset.MoodAsset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodAssetRepository extends JpaRepository<MoodAsset, String> {
}
