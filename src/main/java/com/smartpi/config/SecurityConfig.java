package com.smartpi.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.userDetailsService(userDetailsService);
	// }
	@Autowired
	public void globalUserDetails(final AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("password")
			.roles("USER")
			.and()
			.withUser("mbogusiak")
			.password("password")
			.roles("USER", "ADMIN", "READER", "WRITER")
			.and()
			.withUser("audit")
			.password("audit")
			.roles("USER", "ADMIN", "READER");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		System.out.println("ASDASDASDASDASD");

		http.csrf().disable();
		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/piHome.html", "/home.html", "/login.html", "/")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and();

	}

	private Filter csrfHeaderFilter() {
		return new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(final HttpServletRequest request,
					final HttpServletResponse response,
					final FilterChain filterChain)
					throws ServletException, IOException {
				final CsrfToken csrf = (CsrfToken) request.getAttribute(
						CsrfToken.class.getName());
				if (csrf != null) {
					Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
					final String token = csrf.getToken();
					if (cookie == null || token != null
							&& !token.equals(cookie.getValue())) {
						System.out.println(token);
						System.out.println("!!!!!!!!!!!!!!!!!");

						cookie = new Cookie("XSRF-TOKEN", token);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
				filterChain.doFilter(request, response);
			}
		};
	}

	private CsrfTokenRepository csrfTokenRepository() {
		final HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}

}