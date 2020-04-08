package com.lms.accessingdatajpa.book;

import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;

//repository that extends JPARepository  
	public interface BookItemRepository extends JpaRepository<BookItem, Long>  
	{  
	//List<Book> findByTitle(String title);
	//Book findByIsbn (int isbn);
		
}
