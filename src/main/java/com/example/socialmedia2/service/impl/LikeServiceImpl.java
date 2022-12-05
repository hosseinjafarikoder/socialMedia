package com.example.socialmedia2.service.impl;

import com.example.socialmedia2.base.BaseServiceImpl;
import com.example.socialmedia2.entity.LikeEntity;
import com.example.socialmedia2.repository.LikeRepository;
import com.example.socialmedia2.service.LikeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LikeServiceImpl extends BaseServiceImpl<
        LikeEntity, Long, LikeRepository> implements LikeService {
    public LikeServiceImpl(LikeRepository repository) {
        super(repository);
    }
}
