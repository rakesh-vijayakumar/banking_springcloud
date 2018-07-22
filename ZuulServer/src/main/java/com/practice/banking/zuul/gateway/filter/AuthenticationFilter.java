package com.practice.banking.zuul.gateway.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.practice.banking.zuul.gateway.domain.TokenValidity;

@Component
public class AuthenticationFilter implements Filter {

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String BEARER = "Bearer";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		if (req.getHeader(AUTHORIZATION_HEADER) != null) {
			String authorizationHeader = req.getHeader(AUTHORIZATION_HEADER);
			String token = authorizationHeader.substring(BEARER.length()).trim();

			boolean isValid = tokenProcess(token);

			if (isValid) {
				chain.doFilter(request, response);
			} else {
				createUnsupportedAuthorizationHeader(response);
			}
		}else {
			createUnsupportedAuthorizationHeader(response);
		}
	}

	@Override
	public void destroy() {

	}

	private boolean tokenProcess(String token) {
		RestTemplate restTemplate = new RestTemplate();

		TokenValidity validity = restTemplate.getForObject("http://localhost:9011/token/validate/" + token,
				TokenValidity.class);

		return validity.isActive();
	}

	private void createUnsupportedAuthorizationHeader(ServletResponse response) {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
	}
}
