package project.RealEstateApp.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import project.RealEstateApp.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
	UserEntity findFirstByEmail(String email);

}
