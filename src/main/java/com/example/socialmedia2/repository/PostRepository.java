package com.example.socialmedia2.repository;

import com.example.socialmedia2.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity , Long> {
}
