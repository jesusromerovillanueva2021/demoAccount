package com.example.demoAccount.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demoAccount.entity.Account;

@Repository	
public interface AccountRepository extends ReactiveCrudRepository<Account, Integer> {

}
