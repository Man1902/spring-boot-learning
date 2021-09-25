/*
package com.learning.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		//.authorizeRequests().anyRequest().authenticated()	// OR
		.authorizeRequests().antMatchers("/greeting").hasRole("USER")
		.and()
		.authorizeRequests().antMatchers("/**").hasRole("ADMIN")
		.and()
		.httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password("{noop}password").roles("ADMIN","USER")
		.and()
		.withUser("user").password(encoder().encode("password")).roles("USER");
		// $2a$10$CrCNsBq/yD3.165JMlYcsuH1Oppmt8k.Tnq22KrHD2Wdhs7QP9Jcy
	}
	
	@Bean
	public PasswordEncoder  encoder() {
		return new BCryptPasswordEncoder();
	}
	
}*/
