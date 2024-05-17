package project.RealEstateApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.RealEstateApp.models.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
