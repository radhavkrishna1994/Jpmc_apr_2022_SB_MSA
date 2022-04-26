package com.training.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.training.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationDb extends WebSecurityConfigurerAdapter  {
	Logger log = LoggerFactory.getLogger(SecurityConfigurationDb.class);
	
	@Autowired
	private MyUserDetailsService userDetailsService;

	
	public PasswordEncoder getPasswordEncoder()
	{
		log.info("Inside Password Encoder");
		return new PasswordEncoder()
		{

			@Override
			public String encode(CharSequence rawPassword) {

				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				log.info("Inside Password Encoder matches");
				return rawPassword.equals(encodedPassword);
			}

		};
	}

	//authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		log.info("Inside Configure authentication");
		
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());
	}

	//authorization
	public void configure(HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()
		.antMatchers("/user/**")
		.hasRole("USER")
		//.hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.and()
		.formLogin();

	}



}
