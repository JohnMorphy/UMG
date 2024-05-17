package ksi.springbooks.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ksi.springbooks.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByOrderByIdbAsc();
	List<Book> findByOrderByTitleAsc();
	List<Book> findByOrderByPublisherNameDesc();
	
	List<Book> findAllByTitleNativeSQL();
	
	List<Book> findAllByCategoryAndTitleNativeSQL();

}