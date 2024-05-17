package ksi.springbooks.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")

public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idc;
	private String description;
	
	@OneToMany
	@JoinColumn(name="category_idc")
	private List<Book> books;

	public Category() {
		super();
	}

	public Long getIdc() {
		return idc;
	}

	public void setIdc(Long idc) {
		this.idc = idc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}	

}