package ksi.springbooks.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksi.springbooks.models.Book;
import ksi.springbooks.repositories.BookRepository;
@Service
public class BookService {
	@Autowired
	private BookRepository repository;
	
	public BookService() {
		super();
	
	}

	public <S extends Book> S save(S entity) {
		return repository.save(entity);
	}

	public List<Book> findAll() {
		return repository.findByOrderByIdbAsc();
	}
	
	public List<Book> findAlByCategoryAndTitle() {
		return repository.findAllByCategoryAndTitleNativeSQL();
	}

	public Optional<Book> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}