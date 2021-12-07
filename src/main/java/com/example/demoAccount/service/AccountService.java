package com.example.demoAccount.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoAccount.dto.AccountDto;
import com.example.demoAccount.repository.AccountRepository;
import com.example.demoAccount.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService {
	@Autowired
	private AccountRepository repository;
	
	public Flux<AccountDto> getAccounts(){
		return repository.findAll().map(AppUtils::entityToDto);
	}
	
	public Mono<AccountDto> getAccount(int id){
		return repository.findById(id).map(AppUtils::entityToDto);
	}
	
	public Mono<AccountDto> saveAccount(Mono<AccountDto> accountDtoMono){
		 return accountDtoMono.map(AppUtils::dtoToEntity)
	             .flatMap(repository::save)
	             .map(AppUtils::entityToDto);
	}
	
	public Mono<AccountDto> updateAccount(Mono<AccountDto> accountDtoMono,int id){
	        return repository.findById(id)
	                .flatMap(p->accountDtoMono.map(AppUtils::dtoToEntity)
	                .doOnNext(e->e.setId(id)))
	                .flatMap(repository::save)
	                .map(AppUtils::entityToDto);
	}
	    
	public Mono<Void> deleteAccount(int id){
	        return repository.deleteById(id);
	}
	
	public Mono<List<AccountDto>> getAccountsByIdCustomer(int idCustomer){
		Flux<AccountDto> customersAll=repository.findAll()
					.map(AppUtils::entityToDto);
		Mono<List<AccountDto>> accountsFiltered=Flux.from(customersAll)
				.filter(c->c.getIdCustomer()==idCustomer)
				.collect(Collectors.toList());
		return accountsFiltered;
	}
}
