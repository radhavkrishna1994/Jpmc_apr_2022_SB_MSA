package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.interfaces.BookServiceI;
import com.training.model.Book;

@RequestMapping("/bookstore/api")
@RestController
public class BookController {
	
	@Autowired
	private BookServiceI bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		return bookService.getBooks();
	}
	

}
