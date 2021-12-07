package com.example.demoAccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoAccount.dto.AccountDto;
import com.example.demoAccount.service.AccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService service;
	
	@GetMapping
	public Flux<AccountDto> getAccounts(){
		return service.getAccounts();
	}
	
	@GetMapping("/{id}")
	public Mono<AccountDto> getAccount(@PathVariable int id){
		return service.getAccount(id);
	}
	
	@PostMapping
	public Mono<AccountDto> saveAccount(@RequestBody Mono<AccountDto> accountDtoMono){
		return service.saveAccount(accountDtoMono);
	}
	
	@PutMapping("/update/{id}")
	public Mono<AccountDto> updateAccount(@RequestBody Mono<AccountDto> accountDtoMono,@PathVariable int id){
	    return service.updateAccount(accountDtoMono, id);
	}

	@DeleteMapping("/delete/{id}")
	public Mono<Void> deleteAccount(@PathVariable int id){
	    return service.deleteAccount(id); 
	}
	
	@GetMapping("/accountsbytcustomer/{idCustomer}")
	public Mono<List<AccountDto>> getAccountsByCustomer(@PathVariable int idCustomer){
		return service.getAccountsByIdCustomer(idCustomer);
	}
}




