package project.RealEstateApp.services;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import project.RealEstateApp.models.PropertyPhoto;
import project.RealEstateApp.repositories.PropertyPhotoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyPhotoService {

	@Autowired
    private final PropertyPhotoRepository repository;

    public PropertyPhotoService(PropertyPhotoRepository repository) {
        this.repository = repository;
    }

    public <S extends PropertyPhoto> S save(S entity) {
        return repository.save(entity);
    }

    public List<PropertyPhoto> findAll() {
        return repository.findAll();
    }

    public Optional<PropertyPhoto> findById(Long id) {
        return repository.findById(id);
    }
    

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
