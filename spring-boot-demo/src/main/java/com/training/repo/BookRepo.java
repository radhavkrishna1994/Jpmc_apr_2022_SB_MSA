package com.training.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

	public List<Book> findByTitle(String title);
	public List<Book> findByTitleLike(String title);
	public List<Book> findByStockLessThan(Long Stock);
	
}
