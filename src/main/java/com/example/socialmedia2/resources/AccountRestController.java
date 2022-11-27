package com.example.socialmedia2.resources;

import com.example.socialmedia2.base.BaseRestController;
import com.example.socialmedia2.dto.AccountDto;
import com.example.socialmedia2.entity.AccountEntity;
import com.example.socialmedia2.mapper.AccountMapper;
import com.example.socialmedia2.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountRestController extends BaseRestController<
        AccountDto, AccountEntity, AccountMapper, AccountService, Long> {
    public AccountRestController(AccountService service, AccountMapper mapper) {
        super(service, mapper);
    }
}
