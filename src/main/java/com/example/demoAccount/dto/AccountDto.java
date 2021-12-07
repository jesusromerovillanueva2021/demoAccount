package com.example.demoAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	private int id;
	private AccountType type;
	private double amount;
	private int idCustomer;
	
	public enum AccountType{
		Saving,CurrentAccount,FixedTerm
	}
}
