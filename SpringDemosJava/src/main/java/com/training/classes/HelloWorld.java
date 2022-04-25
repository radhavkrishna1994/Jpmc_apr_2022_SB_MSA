package com.training.classes;

public class HelloWorld {
	
	private String message;
	public HelloWorld() { }
	
	public HelloWorld(String message)
	{
		this.message=message;
	}

	/*
	 * public void setMessage(String message) { this.message=message; }
	 */
	public String sayHello()
	{
		return message;
	}

}
