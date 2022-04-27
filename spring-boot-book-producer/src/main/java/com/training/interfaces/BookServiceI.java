package com.training.interfaces;

import java.util.List;

import com.training.model.Book;

public interface BookServiceI {
	
	public List<Book> getBooks();
	public Book saveBook(Book book);
	public Book getBook(Long isbn);
	public Book deleteBook(Long isbn);
	public Book updateBookStock(Long isbn,Long newStock);

}
