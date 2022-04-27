package com.training.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

	public List<Book> findByTitle(String title);
	public List<Book> findByTitleLike(String title);
	public List<Book> findByStockLessThan(Long Stock);
	
	// get all books which are stocked less than 120
	
	@Query("from Book b where b.stock < :stock ")
	public List<Book> getAllBooksOnStock(@Param("stock") Long Stock);
	
	//update all books that are stocked less than 120 , by adding 50 more stock
	
	@Transactional
	@Modifying
	@Query("update Book b set b.stock = b.stock + :newstock where b.stock < :oldstock")
	public int updateStock(@Param("oldstock")Long oldStock,@Param("newstock") Long newStock);
	
}
