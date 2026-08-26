package com.winemood.winemood_backend.entity.asset;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "site_assets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SiteAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String section;

    @Column(nullable = false)
    private String assetKey;

    @Column(nullable = false)
    private String imageUrl;
}
