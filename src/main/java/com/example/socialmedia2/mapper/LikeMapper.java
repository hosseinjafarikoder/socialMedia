package com.example.socialmedia2.mapper;

import com.example.socialmedia2.base.BaseMapper;
import com.example.socialmedia2.dto.LikeDto;
import com.example.socialmedia2.entity.LikeEntity;
import org.mapstruct.Mapper;


@Mapper
public interface LikeMapper extends BaseMapper<LikeEntity , LikeDto> {
}
