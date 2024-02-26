package ksi.springbooks.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")

@NamedNativeQuery(name = "Book.findAllByTitleNativeSQL",
query = "SELECT * FROM books.book ORDER BY title ",
resultClass = Book.class)

@NamedNativeQuery(name = "Book.findAllByCategoryAndTitleNativeSQL",
query = "SELECT * FROM books.book "
		+ "LEFT JOIN "
		+ "books.category ON "
		+ "books.book.category_idc = books.category.idc "
		+ "ORDER BY books.category.description, books.book.title; ",
resultClass = Book.class)

public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idb;
	private String title;
	
	@ManyToOne
    @JoinColumn(name = "publisher_idp")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "category_idc")
    private Category category;
	
	public Book() {
		super();
	}

	public Long getIdb() {
		return idb;
	}

	public void setIdb(Long idb) {
		this.idb = idb;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
		
}
