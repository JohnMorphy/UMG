package project.RealEstateApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.RealEstateApp.models.UserRole;
import project.RealEstateApp.repositories.UserRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
	private final UserRoleRepository repository;

    public UserRoleService(UserRoleRepository repository) {
        this.repository = repository;
    }

    public <S extends UserRole> S save(S entity) {
        return repository.save(entity);
    }

    public List<UserRole> findAll() {
        return repository.findAll();
    }

    public Optional<UserRole> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // Add other methods as needed
}
