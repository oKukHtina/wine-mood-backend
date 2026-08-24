package com.winemood.winemood_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quiz_result_answers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizResultAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_result_id", nullable = false)
    private QuizResult quizResult;

    @Column(name = "answer_key", nullable = false)
    private String answerKey;

    @Column(name = "answer_value", nullable = false)
    private String answerValue;
}
