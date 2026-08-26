package com.winemood.winemood_backend.entity.asset;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "history_woman_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryWomanImage {
    @Id
    private String id;

    @Column(nullable = false)
    private String imageUrl;
}