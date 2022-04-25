package com.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.classes.AddOperator;
import com.training.classes.HelloWorld;
import com.training.classes.MultiplyOperator;
import com.training.classes.OperatorDemo;
import com.training.interfaces.Operator;

//@Configuration
public class MyConfiguration {

	@Bean
	public HelloWorld getHelloBean()
	{
		return new HelloWorld("This is a message");
		
	}
	
	@Bean(name="add")
	public Operator getOperator()
	{
		return new AddOperator();
	}
	
	
	  @Bean(name="multiply")
	  public Operator getOperator1() { return new MultiplyOperator(); }
	 
	
	@Bean
	public OperatorDemo getOperatorDemo()
	{
		return new OperatorDemo();
	}
	
	
}
