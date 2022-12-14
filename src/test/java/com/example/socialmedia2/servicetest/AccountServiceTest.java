package com.example.socialmedia2.servicetest;

import com.example.socialmedia2.Socialmedia2Application;
import com.example.socialmedia2.entity.AccountEntity;
import com.example.socialmedia2.exceptions.BaseException;
import com.example.socialmedia2.exceptions.IdNullException;
import com.example.socialmedia2.exceptions.NotFoundExceptions;
import com.example.socialmedia2.repository.AccountRepository;
import com.example.socialmedia2.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Socialmedia2Application.class)
public class AccountServiceTest {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountServiceImpl accountService;


    @DisplayName("test method save Account")
    @Test
    public void should_When_Save_Service_Return_Entity() throws BaseException {
        var account = AccountEntity.builder()
                .firstName("ali")
                .lastName("alavi")
                .username("mm74").password("123456")
                .build();

        AccountEntity accountEntity = accountService.saveOrUpdate(account);
        assertThat(accountEntity).isNotNull();
    }

    @DisplayName("test method save when null")
    @Test
    public void should_When_Save_Service_Return_Entity_With_Null() {
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                () -> accountService.saveOrUpdate(null));

    }

    @Test
    public void update_Entity_Service() throws BaseException {
        var account = AccountEntity.builder()
                .firstName("hasan")
                .lastName("hasani")
                .username("h25").password("123456")
                .build();
        AccountEntity accountEntity = accountService.saveOrUpdate(account);
        System.out.println(accountEntity.getFirstName());
        System.out.println(accountEntity.getLastName());
        accountEntity.setFirstName("reza");
        accountEntity.setLastName("rezaei");
        AccountEntity account1 = accountService.saveOrUpdate(accountEntity);
        System.out.println(account1.getFirstName());
        System.out.println(account1.getLastName());
        System.out.println(account1.getLastName());
        Assertions.assertTrue(account1.getId() == accountEntity.getId());
    }

    @Test
    public void should_Return_Throw_Exception_Not_Found_Entity() {
        Assertions.assertThrows(NotFoundExceptions.class,
                () -> accountService.findById(200L));
    }

    @Test
    public void should_Return_Throw_Exception_Not_Found_Entity_When_Give_Null() {
        Assertions.assertThrows(IdNullException.class,
                () -> accountService.findById(null));
    }


    @Test
    public void should_When_Username_And_Password_Return_Entity() throws BaseException {
        var account = AccountEntity.builder()
                .username("ronaldo")
                .password("78946")
                .build();
        AccountEntity accountEntity = accountService.saveOrUpdate(account);
        Assertions.assertAll(
                () -> Assertions.assertEquals(accountEntity.getUsername(), "ronaldo"),
                () -> Assertions.assertEquals(accountEntity.getPassword(), "78946")
        );
    }
}


