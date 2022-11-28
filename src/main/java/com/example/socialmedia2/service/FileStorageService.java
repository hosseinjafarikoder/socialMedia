package com.example.socialmedia2.service;

import com.example.socialmedia2.base.BaseService;
import com.example.socialmedia2.entity.FileEntity;
import com.example.socialmedia2.exceptions.IdNullException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface FileStorageService extends BaseService<FileEntity, Long> {

    public FileEntity store(MultipartFile file) throws IOException;

    public Optional<FileEntity> getFile(Long id) throws IdNullException;

}



