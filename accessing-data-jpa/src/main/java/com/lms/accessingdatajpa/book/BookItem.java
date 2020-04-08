package com.lms.accessingdatajpa.book;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lms.accessingdatajpa.author.Author;
import com.lms.accessingdatajpa.booklending.BookLending;
@Entity

@Table(name = "bookitems")
public class BookItem extends Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true) // Defining barcode as unique key
	private String barcode;
	@Column
	private boolean isReferenceOnly;
	@Column
	private Date borrowed;
	@Column
	private Date dueDate;
	@Column
	private double price;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private BookFormat format;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private BookStatus status;
	@Column
	private Date dateOfPurchase;
	@Column
	private Date publicationDate;

	// private Rack placedAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isReferenceOnly() {
		return isReferenceOnly;
	}

	public void setReferenceOnly(boolean isReferenceOnly) {
		this.isReferenceOnly = isReferenceOnly;
	}

	public Date getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(Date borrowed) {
		this.borrowed = borrowed;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BookFormat getFormat() {
		return format;
	}

	public void setFormat(BookFormat format) {
		this.format = format;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}


	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	@ManyToMany(mappedBy = "bookitems", fetch = FetchType.LAZY)
	private Set<Author> authors = new HashSet<>();
	
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	//////
	@OneToMany(mappedBy = "bookitem", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	private Set<BookLending> booklendings;
	
	public BookItem(){

	    }
	
	
}
