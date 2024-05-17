package project.RealEstateApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.RealEstateApp.models.PropertyPhoto;

public interface PropertyPhotoRepository extends JpaRepository<PropertyPhoto, Long> {

}
