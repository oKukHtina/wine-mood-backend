package com.winemood.winemood_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "quiz_results")
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "quiz_result_wines",
            joinColumns = @JoinColumn(name = "quiz_result_id"),
            inverseJoinColumns = @JoinColumn(name = "wine_id")
    )
    @OrderColumn(name = "position")
    private List<Wine> wines = new ArrayList<>();
}