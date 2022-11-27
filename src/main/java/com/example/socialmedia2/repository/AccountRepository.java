package com.example.socialmedia2.repository;

import com.example.socialmedia2.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    @Query(value = "select a from AccountEntity a where a.username =:username and a.password =:password", nativeQuery = true)
    AccountEntity findByUsernameAndPassword(String username, String password);

    AccountEntity findByUsername(String username);

    Boolean existsByUsername(String username);


}
