package com.example.socialmedia2.service.impl;

import com.example.socialmedia2.base.BaseServiceImpl;
import com.example.socialmedia2.entity.CommentEntity;
import com.example.socialmedia2.repository.CommentRepository;
import com.example.socialmedia2.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl extends BaseServiceImpl<
        CommentEntity, Long, CommentRepository> implements CommentService {
    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }
}
