package com.example.demoAccount.utils;

import org.springframework.beans.BeanUtils;

import com.example.demoAccount.dto.AccountDto;
import com.example.demoAccount.entity.Account;

public class AppUtils {
	public static AccountDto entityToDto(Account account) {
		AccountDto accountDto=new AccountDto();
		BeanUtils.copyProperties(account, accountDto);
		return accountDto;
	}
	
	public static Account dtoToEntity(AccountDto accountDto) {
		Account account=new Account();
		BeanUtils.copyProperties(accountDto, account);
		return account;
	}
}
