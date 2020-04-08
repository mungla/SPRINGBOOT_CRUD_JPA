//https://hellokoding.com/jpa-one-to-many-relationship-mapping-example-with-spring-boot-hsql/
//https://attacomsian.com/blog/spring-data-jpa-one-to-many-mapping
package com.lms.accessingdatajpa.booklending;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.lms.accessingdatajpa.book.BookItem;
@Entity
@Table(name = "booklendings")
public class BookLending {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	@Column
	@Temporal(TemporalType.DATE)
	private Date returnDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bookitem_id", nullable = false)
	private BookItem bookitem;
	public BookLending() {
    }
	public BookLending(Date creationDate, Date dueDate, Date returnDate, BookItem bookitem) {
		//super();
		this.creationDate = creationDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.bookitem = bookitem;
	}
	
		
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public BookItem getBookitem() {
		return bookitem;
	}

	public void setBookitem(BookItem bookitem) {
		this.bookitem = bookitem;
	}
	
	

	
}
