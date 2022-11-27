package com.example.socialmedia2.service.impl;

import com.example.socialmedia2.base.BaseServiceImpl;
import com.example.socialmedia2.entity.AccountEntity;
import com.example.socialmedia2.exceptions.NotFoundExceptions;
import com.example.socialmedia2.repository.AccountRepository;
import com.example.socialmedia2.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl extends BaseServiceImpl<AccountEntity,
        Long, AccountRepository> implements AccountService {
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public AccountEntity findByUsername(String username) {
        AccountEntity accountEntity = repository.findByUsername(username);
        if (accountEntity.getId() == null) {
            throw new NotFoundExceptions("your entity not found");
        } else
            return repository.findByUsername(username);
    }


    @Override
    public AccountEntity findByUsernameAndPassword(String username, String password) {
        AccountEntity accountEntity = repository.findByUsernameAndPassword(username, password);
        if (accountEntity.getId() == null) {
            throw new NotFoundExceptions("your entity not found");
        } else
            return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }
}
