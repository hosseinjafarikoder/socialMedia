package com.example.socialmedia2.service.impl;

import com.example.socialmedia2.base.BaseServiceImpl;
import com.example.socialmedia2.entity.PostEntity;
import com.example.socialmedia2.repository.PostRepository;
import com.example.socialmedia2.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PostServiceImpl extends BaseServiceImpl<
        PostEntity, Long, PostRepository> implements PostService {
    public PostServiceImpl(PostRepository repository) {
        super(repository);
    }
}
