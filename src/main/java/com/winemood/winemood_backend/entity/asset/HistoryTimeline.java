package com.winemood.winemood_backend.entity.asset;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "history_timeline")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryTimeline {
    @Id
    private String id;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;
}