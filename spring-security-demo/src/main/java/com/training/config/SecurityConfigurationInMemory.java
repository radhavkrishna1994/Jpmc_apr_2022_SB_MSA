package com.training.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfigurationInMemory extends WebSecurityConfigurerAdapter  {
	
	//authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		//System.out.println("Authentication.."+auth);
		auth
		.inMemoryAuthentication()
		.withUser("user1")
		.password("{noop}user1")
		.roles("USER")
		.and()
		.withUser("admin")
		.password("admin")
		.roles("ADMIN");
						
	}
	
	
	//authorization
	
	

}
