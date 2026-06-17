package com.winemood.winemood_backend.repository;

import com.winemood.winemood_backend.entity.WineTasteProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineTasteProfileRepository extends JpaRepository<WineTasteProfile, Long> {
}
