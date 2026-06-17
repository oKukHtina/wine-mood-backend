package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.AromaNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AromaNoteRepository extends JpaRepository<AromaNote, Long> {
}
