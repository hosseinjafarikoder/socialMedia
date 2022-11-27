package com.example.socialmedia2.mapper;

import com.example.socialmedia2.base.BaseMapper;
import com.example.socialmedia2.dto.PostDto;
import com.example.socialmedia2.entity.PostEntity;
import org.mapstruct.Mapper;


@Mapper
public interface PostMapper extends BaseMapper<PostEntity , PostDto> {
}
