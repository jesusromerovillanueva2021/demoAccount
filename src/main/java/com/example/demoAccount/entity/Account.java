package com.example.demoAccount.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demoAccount.dto.AccountDto.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("account")
public class Account {
	@Id
	private int id;
	private AccountType type;
	private double amount;
}
