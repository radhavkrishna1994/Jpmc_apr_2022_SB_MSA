package com.training.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.training.entity.Book;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/book")
public class BookConsumerController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getPBook/isbn/{isbn}/qty/{qty}")
	//localhost:8087/book/getPBook/isbn/8976/qty/10
	@CircuitBreaker( name = "consumer_service",fallbackMethod = "defaultFallBack")
	public Book getPurchasedBook(@PathVariable("isbn") String isbn,@PathVariable("qty") int qty)
	{
		//String url="http://localhost:8082/book/getbook/isbn/{isbn}";
		String url = "http://localhost:8081/bookstore/api/book/isbn/{isbn}";
		//http://localhost:8082/book/getbook/isbn/8976
		
		Map<String,String> uriVariables=new HashMap<>();
		uriVariables.put("isbn", isbn);
		Book book = restTemplate.getForObject(url, Book.class, uriVariables);
		book.setQty(qty);
		book.setAmount(book.getQty() * book.getPrice());
		return book;
	}
	
	public Book  defaultFallBack(String isbn,int qty,Throwable t)
	{
		//return new Book("0000", null, 0, 0, 0, 0);
		return new Book();
		
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}










