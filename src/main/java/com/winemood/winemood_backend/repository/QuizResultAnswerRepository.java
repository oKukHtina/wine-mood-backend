package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.QuizResultAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizResultAnswerRepository extends JpaRepository<QuizResultAnswer, Long> {
}