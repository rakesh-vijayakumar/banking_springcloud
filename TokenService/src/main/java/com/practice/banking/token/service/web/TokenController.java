package com.practice.banking.token.service.web;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.banking.token.service.domain.Token;
import com.practice.banking.token.service.domain.TokenRepository;
import com.practice.banking.token.service.domain.TokenValidity;

@RestController
@RequestMapping("/token")
public class TokenController {

	private TokenRepository tokenRepository;

	public TokenController(TokenRepository tokenRepository) {
		this.tokenRepository = tokenRepository;
	}

	@GetMapping("/issue")
	public Token issueToken() {
		System.out.println("inside token controller");
		Token token = new Token();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, 20);
		token.setIssuedAt(date);
		token.setExpiresAt(cal.getTime());
		Token tokenSaved = tokenRepository.save(token);
		return tokenSaved;
	}

	@GetMapping("/validate/{token}")
	public TokenValidity tokenValidate(@PathVariable String token) {
		TokenValidity validity = new TokenValidity();
		Optional<Token> tokenObj = tokenRepository.findById(token);
		if (tokenObj.isPresent()) {
			System.out.println(tokenObj.toString());
			Date date = new Date();

			if (tokenObj.get().getExpiresAt().getTime() > date.getTime()) {
				validity.setActive(true);
			}
			return validity;
		}

		return validity;
	}
}
