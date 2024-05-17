package project.RealEstateApp.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import project.RealEstateApp.dto.UserDTO;
import project.RealEstateApp.models.UserEntity;
import project.RealEstateApp.models.UserRole;
import project.RealEstateApp.repositories.UserRepository;
import project.RealEstateApp.repositories.UserRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private final BCryptPasswordEncoder passwordEncoder;

	private final UserRepository userRepository;
	private final UserRoleService userRoleService;
	private final UserDataService userDataService;
	
	public UserService(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository,
			UserRoleService userRoleService, UserDataService userDataService) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.userRoleService = userRoleService;
		this.userDataService = userDataService;
	}

	public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    
    public UserEntity findByEmail(String email) {
    	return userRepository.findByEmail(email);
    }
    
    public Optional<UserEntity> findById(Long id) {
		return userRepository.findById(id);
    }

    public void deleteById(Long id) {
    	userRepository.deleteById(id);
    }

    public void registerUser(UserDTO userDTO) {
		
		UserEntity regiseredUser = new UserEntity();
        regiseredUser.setUsername(userDTO.getUsername());
        regiseredUser.setEmail(userDTO.getEmail());
        regiseredUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
      
        Optional<UserRole> roleExists =  userRoleService.findById(1L);
        
        if(roleExists.isPresent()) {
        	
        	UserRole userRole = roleExists.get();
        	
        	regiseredUser.setUser_role(userRole);
        	regiseredUser.setUser_role(userRole);
	        
        	UserEntity savedUser = store(regiseredUser);
	
	        userDataService.createEmpty(savedUser);
        } else {
            throw new IllegalStateException("Default role not found in the database.");
        }
	}
    
    public UserEntity store(UserEntity user) {
    	return userRepository.save(user);
    }

	
        
}
