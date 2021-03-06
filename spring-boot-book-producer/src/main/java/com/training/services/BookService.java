package com.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.interfaces.BookServiceI;
import com.training.model.Book;
import com.training.repo.BookRepo;

@Service
public class BookService implements BookServiceI {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<Book> getBooks() {
		
		return bookRepo.findAll();
	}

	@Override
	public Book saveBook(Book book) {
		
		return bookRepo.save(book);
	}

	@Override
	public Book getBook(Long isbn) {
		
		Optional<Book> opBook = bookRepo.findById(isbn);
		if(opBook.isPresent())
			return opBook.get();
		
		return null;
	}

	@Override
	public Book deleteBook(Long isbn) {
		Optional<Book> opBook = bookRepo.findById(isbn);
		Book bookFound = null;
		if(opBook.isPresent())
		{
			bookFound=opBook.get();
			bookRepo.delete(bookFound);
			return bookFound;
		}
		return null;
	}

	@Override
	public Book updateBookStock(Long isbn, Long newStock) {
		Optional<Book> opBook = bookRepo.findById(isbn);
		Book bookFound = null;
		if(opBook.isPresent())
		{
			bookFound=opBook.get();
			bookFound.setStock(bookFound.getStock()+newStock);
			bookRepo.save(bookFound);
			return bookFound;
		}
		return null;
	}

}
