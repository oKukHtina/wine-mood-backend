package com.winemood.winemood_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FavoriteWineId implements Serializable {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "wine_id")
    private Long wineId;
}
