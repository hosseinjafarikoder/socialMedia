package com.example.socialmedia2.service.impl;

import com.example.socialmedia2.base.BaseServiceImpl;
import com.example.socialmedia2.entity.FileEntity;
import com.example.socialmedia2.exceptions.IdNullException;
import com.example.socialmedia2.repository.FileDBRepository;
import com.example.socialmedia2.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional
public class FileStorageServiceImpl extends BaseServiceImpl<FileEntity, Long, FileDBRepository> implements FileStorageService {

    @Autowired
    private FileDBRepository fileDBRepository;

    public FileStorageServiceImpl(FileDBRepository repository) {
        super(repository);
    }

    @Override
    public FileEntity store(MultipartFile file) throws IOException {
        if (file == null) {
            throw new IOException();
        } else {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            FileEntity File = new FileEntity(fileName, file.getContentType(), file.getBytes());

            return fileDBRepository.save(File);
        }
    }

    @Override
    public Optional<FileEntity> getFile(Long id) throws IdNullException {
        if (id == null) {
            throw new IdNullException("the file Id is null");
        }
        return fileDBRepository.findById(id);
    }

}
