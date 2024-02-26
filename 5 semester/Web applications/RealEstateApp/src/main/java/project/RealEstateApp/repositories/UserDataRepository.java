package project.RealEstateApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.RealEstateApp.models.UserData;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

	Optional<UserData> findByUser_Id(Long userId);

}
