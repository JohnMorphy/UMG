package ksi.springbooks.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ksi.springbooks.models.Publisher;
import ksi.springbooks.repositories.PublisherRepository;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepository repository;
	
	public PublisherService() {
		super();
	}

	public <S extends Publisher> S save(S entity) {
		return repository.save(entity);
	}

	public List<Publisher> findAll() {
		return repository.findAll();
	}

	public Optional<Publisher> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}