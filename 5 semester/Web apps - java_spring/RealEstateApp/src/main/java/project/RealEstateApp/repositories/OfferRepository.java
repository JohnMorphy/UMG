package project.RealEstateApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.RealEstateApp.models.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
   
	@Query("SELECT o FROM Offer o WHERE o.user_id.id = :userId")
    List<Offer> findByUserId(@Param("userId") Long userId);
}
