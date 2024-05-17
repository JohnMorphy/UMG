package project.RealEstateApp.services;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import project.RealEstateApp.dto.OfferDTO;
import project.RealEstateApp.models.Offer;
import project.RealEstateApp.models.UserEntity;
import project.RealEstateApp.repositories.OfferRepository;
import project.RealEstateApp.repositories.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {
	
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    
    public OfferService(OfferRepository offerRepository, UserRepository userRepository) throws Exception {
		super();
		this.offerRepository = offerRepository;
		this.userRepository = userRepository;
	}

	public void createOffer(OfferDTO offerDTO) throws Exception {
		
		System.out.println(offerDTO);
		
    	Offer offer = new Offer();
    	
    	UserEntity user = userRepository.findById(offerDTO.getUser_id())
                .orElseThrow(() -> new Exception("User doesn't exist in the database"));

        if(user == null) {
        	throw new Exception("User doesn't exist in database");
        }
        
    	offer.setUser_id(user);
        offer.setDescription(offerDTO.getDescription());
        offer.setTitle(offerDTO.getTitle());
        offer.setOffer_postalCode(offerDTO.getOffer_postalCode());
        offer.setOffer_price(offerDTO.getOffer_price());
        offer.setArea_in_meters(offerDTO.getArea_in_meters());

        LocalDate expirationDate = LocalDate.parse(offerDTO.getExpiration_date(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        offer.setExpiration_date(expirationDate);
        offer.setCity(offerDTO.getCity());
        offer.setStreet(offerDTO.getStreet());
        offer.setAddress(offerDTO.getAddress());
        
        save(offer);
    }
    
    public <S extends Offer> S save(S entity) {
        return offerRepository.save(entity);
    }

    public List<Offer> findAll() {
        return offerRepository.findAll();
    }
    
    public List<Offer> findAllUsersOffer(Long id) {
        return offerRepository.findByUserId(id);
    }

    public Optional<Offer> findById(Long id) {
        return offerRepository.findById(id);
    }

    public void deleteById(Long id) {
        offerRepository.deleteById(id);
    }

    
    public List<Offer> filterByCity(List<Offer> offers, String city) {
        return offers.stream()
                .filter(offer -> offer.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Offer> filterByMinPrice(List<Offer> offers, Integer minPrice) {
        return offers.stream()
                .filter(offer -> offer.getOffer_price() >= minPrice)
                .collect(Collectors.toList());
    }

    public List<Offer> filterByMaxPrice(List<Offer> offers, Integer maxPrice) {
        return offers.stream()
                .filter(offer -> offer.getOffer_price() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<Offer> filterByMinArea(List<Offer> offers, Integer minArea) {
        return offers.stream()
                .filter(offer -> offer.getArea_in_meters() >= minArea)
                .collect(Collectors.toList());
    }

    public List<Offer> filterByMaxArea(List<Offer> offers, Integer maxArea) {
        return offers.stream()
                .filter(offer -> offer.getArea_in_meters() <= maxArea)
                .collect(Collectors.toList());
    }

}
