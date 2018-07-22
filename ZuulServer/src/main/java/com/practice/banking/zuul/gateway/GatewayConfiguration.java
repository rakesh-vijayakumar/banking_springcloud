package com.practice.banking.zuul.gateway;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.practice.banking.zuul.gateway.filter.AuthenticationFilter;

@Configuration
@ComponentScan(basePackages = "com.practice.banking.zuul.gateway")
public class GatewayConfiguration {

	@Bean
	public FilterRegistrationBean someFilterRegistration() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new AuthenticationFilter());
		registration.addUrlPatterns("/*");
		registration.setEnabled(true);
		registration.setName("Authentication Filter");
		registration.setOrder(1);
		return registration;
	}

}
