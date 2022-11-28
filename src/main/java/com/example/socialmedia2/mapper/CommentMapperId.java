package com.example.socialmedia2.mapper;

import com.example.socialmedia2.base.BaseMapper;
import com.example.socialmedia2.dto.CommentDtoId;
import com.example.socialmedia2.entity.CommentEntity;
import org.mapstruct.Mapper;


@Mapper
public interface CommentMapperId extends BaseMapper<CommentEntity , CommentDtoId> {
}
