package com.practice.banking.token.service.domain;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TokenRepository extends MongoRepository<Token, String> {
	Optional<Token> findById(String token);
}
