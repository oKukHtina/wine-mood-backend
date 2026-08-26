package com.winemood.winemood_backend.repository.asset;

import com.winemood.winemood_backend.entity.asset.SiteAsset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteAssetRepository extends JpaRepository<SiteAsset, Long> {
}
