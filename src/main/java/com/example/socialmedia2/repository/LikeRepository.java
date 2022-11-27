package com.example.socialmedia2.repository;

import com.example.socialmedia2.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeEntity , Long> {
}
