package com.lms.accessingdatajpa.author;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.lms.accessingdatajpa.book.BookItem;
import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	@Column
	private String middlename;
	@Column
	private String lastname;
	@Column
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "authors_books", 
	joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id",
	nullable = false, updatable = false),
	inverseJoinColumns = @JoinColumn(name = "book_id", 
	referencedColumnName = "id", nullable = false, updatable = false))

	private Set<BookItem> bookitems = new HashSet<>();

//	protected Author() {
//	}
	

	public Author(String firstname, String middlename, String lastname, String description, Set<BookItem> bookitems) {
		//super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.description = description;
		this.bookitems = bookitems;
	}
	public Author() {
		// TODO Auto-generated constructor stub
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<BookItem> getBookitems() {
		return bookitems;
	}

	public void setBookitems(Set<BookItem> bookitems) {
		this.bookitems = bookitems;
	}
}