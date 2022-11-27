package com.example.socialmedia2.mapper;

import com.example.socialmedia2.base.BaseMapper;
import com.example.socialmedia2.dto.AccountDto;
import com.example.socialmedia2.entity.AccountEntity;
import org.mapstruct.Mapper;


@Mapper
public interface AccountMapper extends BaseMapper<AccountEntity , AccountDto> {
}
