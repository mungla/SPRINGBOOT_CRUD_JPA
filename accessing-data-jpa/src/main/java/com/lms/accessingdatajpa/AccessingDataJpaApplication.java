package com.lms.accessingdatajpa;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.lms.accessingdatajpa.author.Author;
import com.lms.accessingdatajpa.author.AuthorRepository;
import com.lms.accessingdatajpa.book.BookFormat;
import com.lms.accessingdatajpa.book.BookItem;
import com.lms.accessingdatajpa.book.BookItemRepository;
import com.lms.accessingdatajpa.book.BookStatus;
import com.lms.accessingdatajpa.booklending.BookLending;
import com.lms.accessingdatajpa.booklending.BookLendingRepository;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	 @Bean
	 public CommandLineRunner mappingDemo(AuthorRepository authorrepository,
			 BookItemRepository bookitemrepository,
			 BookLendingRepository booklendingrepository) {
		 return (args) -> {
			 Author author = new Author();
			 author.setFirstname("John");
			 author.setMiddlename("Doe");
			 author.setLastname("Abraham");
			 author.setDescription("Professor");
			 
			 authorrepository.save(author); 
			 
			 BookItem bookitem1 = new BookItem();
			 bookitem1.setPrice(300);
			 bookitem1.setReferenceOnly(true);
			 bookitem1.setBorrowed(null);
			 bookitem1.setDueDate(null);
			 bookitem1.setFormat(BookFormat.EBOOK);
			 bookitem1.setStatus(BookStatus.LOANED);
			 bookitem1.setDateOfPurchase(null);
			 bookitem1.setPublicationDate(null);
			 bookitem1.setISBN("123");
			 bookitem1.setTitle("Spring Boot 2ndEdition");
			 bookitem1.setSubject("Programming");
			 bookitem1.setPublisher("Yoh Didier");
			 bookitem1.setLanguage("English");
			 bookitem1.setNumberOfPages(0);
			 bookitemrepository.saveAll(Arrays.asList(bookitem1));
			 //add books to the author 
			 author.getBookitems().addAll(Arrays.asList(bookitem1));
			 authorrepository.save(author);  
//	https://www.baeldung.com/hibernate-date-time
// https://javabydeveloper.com/temporal/
//https://hellokoding.com/jpa-one-to-many-relationship-mapping-example-with-spring-boot-hsql/			 
			 booklendingrepository.save(new BookLending(new Date(), 
					 new SimpleDateFormat("yyyy-MM-dd").parse("2020-06-15"),null, bookitem1));
			 booklendingrepository.save(new BookLending(new Date(), 
					 new SimpleDateFormat("yyyy-MM-dd").parse("2020-07-15"),null, bookitem1));
		 };
	 }
	
	 
}
