package com.example.socialmedia2.mapper;

import com.example.socialmedia2.base.BaseMapper;
import com.example.socialmedia2.dto.CommentDto;
import com.example.socialmedia2.entity.CommentEntity;
import org.mapstruct.Mapper;


@Mapper
public interface CommentMapper extends BaseMapper<CommentEntity , CommentDto> {
}
