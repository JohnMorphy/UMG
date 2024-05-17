package ksi.springbooks.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ksi.springbooks.models.Category;
import ksi.springbooks.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public CategoryService() {
		super();
	}

	public <S extends Category> S save(S entity) {
		return repository.save(entity);
	}

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Optional<Category> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}