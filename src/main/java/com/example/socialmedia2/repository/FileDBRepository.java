package com.example.socialmedia2.repository;


import com.example.socialmedia2.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDBRepository extends JpaRepository<FileEntity, Long> {
}