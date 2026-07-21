package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.QuizResult;
import com.winemood.winemood_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {
    List<QuizResult> findAllByUserOrderByCreatedAtDesc(User user);
}
