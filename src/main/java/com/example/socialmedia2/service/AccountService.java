package com.example.socialmedia2.service;

import com.example.socialmedia2.base.BaseService;
import com.example.socialmedia2.entity.AccountEntity;

public interface AccountService extends BaseService<AccountEntity, Long> {
    AccountEntity findByUsername(String username);

    AccountEntity findByUsernameAndPassword(String username, String password);

    Boolean existsByUsername(String username);
}
