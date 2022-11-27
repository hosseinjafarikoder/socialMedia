package com.example.socialmedia2.repository;

import com.example.socialmedia2.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity , Long> {
}
