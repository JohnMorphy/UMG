package project.RealEstateApp.controllers;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.RealEstateApp.dto.OfferDTO;
import project.RealEstateApp.dto.UserDTO;
import project.RealEstateApp.dto.UserDataDTO;
import project.RealEstateApp.models.Offer;
import project.RealEstateApp.models.UserData;
import project.RealEstateApp.models.UserEntity;
import project.RealEstateApp.models.PropertyPhoto;

import project.RealEstateApp.services.OfferService;
import project.RealEstateApp.services.UserDataService;
import project.RealEstateApp.services.UserService;
import project.RealEstateApp.services.PropertyPhotoService;


@Controller
public class WebController {

    private final OfferService offerService;
    private final UserService userService;
    private final UserDataService userDataService;
    private final PropertyPhotoService photoService;
    

    

	public WebController(OfferService offerService, UserService userService, UserDataService userDataService,
			PropertyPhotoService photoService) {
		super();
		this.offerService = offerService;
		this.userService = userService;
		this.userDataService = userDataService;
		this.photoService = photoService;
	}

	@GetMapping({"/", "/offers"})
    public String home(Model model, @RequestParam(name = "city", required = false) String city,
            @RequestParam(name = "minPrice", required = false) Integer minPrice,
            @RequestParam(name = "maxPrice", required = false) Integer maxPrice,
            @RequestParam(name = "minArea", required = false) Integer minArea,
            @RequestParam(name = "maxArea", required = false) Integer maxArea)  {
		
		List<Offer> offers = offerService.findAll();
    	
		if(minPrice == null) {
			System.out.print("minPrice jest null");
		} else {
			System.out.print(minPrice + ", " + minPrice.getClass());
		}
		
		offers = applyFilters(offers, city, minPrice, maxPrice, minArea, maxArea);
		
		model.addAttribute("offers", offers);
        return "offer_list";
    }
	
	private List<Offer> applyFilters(List<Offer> offers, String city, Integer minPrice, Integer maxPrice,
            Integer minArea, Integer maxArea) {
		
			if (city != null && !city.isEmpty()) {
			offers = offerService.filterByCity(offers, city);
			}

			if (minPrice != null) {
			offers = offerService.filterByMinPrice(offers, minPrice);
			}
			
			if (maxPrice != null) {
			offers = offerService.filterByMaxPrice(offers, maxPrice);
			}
			
			if (minArea != null) {
				offers = offerService.filterByMinArea(offers, minArea);
			}
			
			if (maxArea != null) {
				offers = offerService.filterByMaxArea(offers, maxArea);
			}

		return offers;
	}
	
	
    
    @GetMapping("/view_personal")
    public String viewPersonal(Model model) {
        
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication.getPrincipal() == null || !(authentication.getPrincipal() instanceof UserEntity)) {
        	model.addAttribute("message", "You need to be logged in to perform this action");
        	model.addAttribute("user", new UserDTO());
        	return "login";
        }
        
        UserEntity user = (UserEntity)authentication.getPrincipal();

        System.out.println("user email: " + user.getEmail());

        UserData userData = userDataService.findByUserId(user.getId()).get();
        List<Offer> offers = offerService.findAllUsersOffer(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("userData", userData);
        model.addAttribute("offers", offers);

        return "view_personal";
    }
     
    @GetMapping("/user_data_edit")
    public String editUserData(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() == null || !(authentication.getPrincipal() instanceof UserEntity)) {
        	model.addAttribute("message", "You need to be logged in to perform this action");
        	model.addAttribute("user", new UserDTO());
            return "login";
        }
        
        UserEntity currentUser = (UserEntity) authentication.getPrincipal();
        Long currentUserId = (Long)currentUser.getId();

        UserData userData = userDataService.findByUserId(currentUserId).get();
        
        if (userData != null) {
        	UserDataDTO userDataDTO = new UserDataDTO(
        			userData.getId(),
        			userData.getUser().getId(),
        			userData.getUser_firstname(),
        			userData.getUser_lastname(),
        			userData.getUser_phonenumber()
        		);
        	model.addAttribute("userData", userDataDTO);
        	return "user_data_edit";
        } else {
          	model.addAttribute("message", "userData doesn't exist");
           	model.addAttribute("user", new UserDTO());
            return "login";
        }

    }
    
    @PostMapping("/user_data_update")
    public String updateUserData(@ModelAttribute("userData") UserDataDTO userDataDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
    		model.addAttribute("error", "Wrong user data format");
            return "redirect:/user_edit_data";
        }
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() == null || !(authentication.getPrincipal() instanceof UserEntity)) {
        	model.addAttribute("message", "You need to be logged in to perform this action");
        	model.addAttribute("user", new UserDTO());
            return "login";
        }
        
        try {
	        System.out.println("got here");
	        
	        System.out.println(userDataDTO.getId() + " " + userDataDTO.getUser_firstname() + " "+ userDataDTO.getUser_lastname() + userDataDTO.getUser_phonenumber());
	        UserData userData = userDataService.findById(userDataDTO.getId()).orElseThrow(() ->new Exception("User Data not found"));
	        
	        userData.setUser_firstname(userDataDTO.getUser_firstname());
	        userData.setUser_lastname(userDataDTO.getUser_lastname());
	        userData.setUser_phonenumber(userDataDTO.getUser_phonenumber());
	        
	        userDataService.save(userData);
	
	        return "redirect:/view_personal";
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	return "redirect:/offers";
		}
        
    }
         
    @GetMapping("/offer_create")
    public String createOfferView(Model model) {
        
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() == null || !(authentication.getPrincipal() instanceof UserEntity)) {
        	model.addAttribute("message", "You need to be logged in to perform this action");
        	model.addAttribute("user", new UserDTO());
            return "login";
        }
        
        UserEntity currentUser = (UserEntity) authentication.getPrincipal();
        Long currentUserId = (Long)currentUser.getId();
        
        OfferDTO offerDTO = new OfferDTO();
        offerDTO.setUser_id(currentUserId);
        offerDTO.setExpirationDateThreeMonthsFromNow();       
        model.addAttribute("offerDTO", offerDTO);
    	
        return "offer_create";
    }
    
    @PostMapping("/offer_create")
    public String createOffer(@ModelAttribute("offerDTO") OfferDTO offerDTO, BindingResult result, Model model) {
        
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() == null || !(authentication.getPrincipal() instanceof UserEntity)) {
        	model.addAttribute("message", "You need to be logged in to perform this action");
        	model.addAttribute("user", new UserDTO());
            return "login";
        }

        try {
			offerService.createOffer(offerDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/offer_create";
		}
              
        
    	
        return "redirect:/view_personal";
    }
    
    @GetMapping("/offer_getById/{id}")
    public String getOfferById(@PathVariable("id") Long offerId, Model model) {
    	try {
	        Offer offer = offerService.findById(offerId).orElseThrow(() -> new Exception("Offer not found"));
	        UserData userData = userDataService.findByUserId(offer.getUser_id().getId()).orElseThrow(() -> new Exception("Offer not found"));
	        model.addAttribute("offer", offer);
	        model.addAttribute("userData", userData);
	        return "offer_getById";
    	} catch(Exception ex) {
    		return "redirect:/offers";
    	}
    }
    
    @GetMapping("/delete_offer/{id}")
    public String deleteOfferById(@PathVariable("id") Long offerId, Model model) {
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
    	if (authentication.getPrincipal() == null || !(authentication.getPrincipal() instanceof UserEntity)) {
        	model.addAttribute("message", "You need to be logged in to perform this action");
        	model.addAttribute("user", new UserDTO());
        	return "login";
        }
    	
    	try {
	    	Offer offer = offerService.findById(offerId).orElseThrow(() -> new Exception("Offer not found"));
	        
	    	UserEntity userEntity = (UserEntity)authentication.getPrincipal();
	    	if(userEntity.getId() != offer.getUser_id().getId()) {
	    		return "redirect:/offers";
	    	}
	    	
	    	deleteOfferPhotosFromDisk(offer);
	    	offerService.deleteById(offer.getId());
	    	
	    	return "redirect:/view_personal";
	    
    	} catch (Exception ex) {
    		return "redirect:/view_personal";
    	}
    }

    private void deleteOfferPhotosFromDisk(Offer offer) {
        for (PropertyPhoto offerPhoto : offer.getPhotos()) {
            String filePath = offerPhoto.getFilepath();
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
            photoService.deleteById(offerPhoto.getId());
        }
    }
    

}
