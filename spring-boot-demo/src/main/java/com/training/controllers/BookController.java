package com.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Book;

@RequestMapping("/bookstore/api")
@RestController
public class BookController {
	
	@GetMapping("/books")
	public Book getBook()
	{
		return new Book(2345l, "Let Us C", 125.50, 100l);
	}
	

}
