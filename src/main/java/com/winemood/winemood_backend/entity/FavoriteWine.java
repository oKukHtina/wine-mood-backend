package com.winemood.winemood_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "favorite_wines")
public class FavoriteWine {
    @EmbeddedId
    private FavoriteWineId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("wineId")
    @JoinColumn(name = "wine_id")
    private Wine wine;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
