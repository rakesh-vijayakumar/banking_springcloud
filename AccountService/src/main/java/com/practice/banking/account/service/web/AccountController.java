package com.practice.banking.account.service.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.banking.account.service.domain.Account;
import com.practice.banking.account.service.domain.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private AccountRepository accountRepository;

	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@GetMapping("/{id}")
	public Account getAccountById(@PathVariable Integer id) {
		Account account = accountRepository.findOne(id);

		if (account == null) {
			ResponseEntity.notFound().build();
		}

		return account;
	}
}
