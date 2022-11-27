package com.example.socialmedia2.mapper;

import com.example.socialmedia2.base.BaseMapper;
import com.example.socialmedia2.dto.FileDto;
import com.example.socialmedia2.entity.FileEntity;
import org.mapstruct.Mapper;


@Mapper
public interface FileMapper extends BaseMapper<FileEntity , FileDto> {
}
