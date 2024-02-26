package project.RealEstateApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.RealEstateApp.models.UserData;
import project.RealEstateApp.models.UserEntity;
import project.RealEstateApp.repositories.UserDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

	@Autowired
    private final UserDataRepository repository;

    public UserDataService(UserDataRepository repository) {
        this.repository = repository;
    }
    
    public UserData createEmpty(UserEntity savedUser) {
    	UserData userData = new UserData();
    	userData.setUser(savedUser);
        userData.setUser_firstname("");
        userData.setUser_lastname("");
        userData.setUser_phonenumber(0);
    	
        save(userData);
        
        return userData;
    }

    public <S extends UserData> S save(S entity) {
        return repository.save(entity);
    }

    public List<UserData> findAll() {
        return repository.findAll();
    }


    public Optional<UserData> findByUserId(Long userId) {
    	return repository.findByUser_Id(userId);
    }
    
    public Optional<UserData> findById(Long id) {
    	return repository.findById(id);
    }
    

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
