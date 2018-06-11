package com.practice.banking.customer.service.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.banking.customer.service.domain.Customer;
import com.practice.banking.customer.service.domain.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerRepository customerRepository;

	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
		System.out.println(id);
		Customer customer = customerRepository.findOne(id);

		if (customer == null) {
			ResponseEntity.notFound().build();
		}

		return customer;
	}
}
