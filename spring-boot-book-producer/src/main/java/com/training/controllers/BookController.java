package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.interfaces.BookServiceI;
import com.training.model.Book;

@RequestMapping("/bookstore/api")
@RestController
public class BookController {
	@Value("${server.port}")
	private int port;
	
	@Autowired
	private BookServiceI bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		return bookService.getBooks();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/book")
	public Book saveBook(@RequestBody Book book)
	{
		return bookService.saveBook(book);
	}
	
	@GetMapping("/book/isbn/{isbn}")  //http://localhost:8081/bookstore/api/book/isbn/1234
	public Book getBook(@PathVariable("isbn") Long isbn)//,@RequestHeader("header") String header)
	{
		Book book = bookService.getBook(isbn);
		book.setPort(port);
		return book;
	}
	
	@DeleteMapping("/book/isbn/{isbn}")  //http://localhost:8081/bookstore/api/book/isbn/1234
	public Book delBook(@PathVariable("isbn") Long isbn)
	{
		return bookService.deleteBook(isbn);
	}
	
	@PutMapping("/book/isbn/{isbn}/stock/{newstock}")  //http://localhost:8081/bookstore/api/book/isbn/1234/stock/50
	public Book updateBookStock(@PathVariable("isbn") Long isbn,@PathVariable("newstock") Long newStock)
	{
		return bookService.updateBookStock(isbn, newStock);
	}

}
