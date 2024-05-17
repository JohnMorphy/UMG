package project.RealEstateApp.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import project.RealEstateApp.dto.UserDTO;
import project.RealEstateApp.repositories.UserRoleRepository;
import project.RealEstateApp.security.CustomAuthenticationProvider;
import project.RealEstateApp.services.UserDataService;
import project.RealEstateApp.services.UserService;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final UserDataService userDataService;
    private final UserRoleRepository userRoleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;
    private final CustomAuthenticationProvider customAuthenticationProvider;
    

	public RegistrationController(UserService userService, UserDataService userDataService,
			UserRoleRepository userRoleRepository, BCryptPasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService, CustomAuthenticationProvider customAuthenticationProvider) {
		super();
		this.userService = userService;
		this.userDataService = userDataService;
		this.userRoleRepository = userRoleRepository;
		this.passwordEncoder = passwordEncoder;
		this.userDetailsService = userDetailsService;
		this.customAuthenticationProvider = customAuthenticationProvider;
	}

	@GetMapping("/register")
    public String showRegistrationForm(Model model) {
		
        model.addAttribute("user", new UserDTO());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserDTO userDTO, BindingResult result, Model model) {
	
        if (result.hasErrors()) {
        	model.addAttribute("error", "Error occurred during validation");
        	System.out.println("Error here");
            return "register";
        }

        try {
            userService.registerUser(userDTO);
            model.addAttribute("message", "Registration successful. You can now log in.");
            model.addAttribute("user", userDTO);
            return "login";

        } catch (Exception ex) {
        	model.addAttribute("error", "Email already exists, or elements exceed size limit");
            return "register";
        }
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("user") UserDTO user, Model model) {
    		
    	return "redirect:/view_personal";
    }
    
    /*
    private void authenticateUserAndSetSession(UserDTO user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(userDetails, user.getPassword());
        System.out.println(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();

        try {
            System.out.println("Authenticating user with CustomAuthenticationProvider...");
            UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) customAuthenticationProvider.authenticate(authReq);
            sc.setAuthentication(auth);
            System.out.println("Authentication set in security context: " + sc.getAuthentication());
        } catch (AuthenticationException ex) {
            System.out.println("Authentication failed: " + ex.getMessage());
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println((authentication != null) + ", and is User? " + (authentication.getPrincipal()));
    }
    */

    @GetMapping("/logout")
    public String logout(Model model) {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/offers";
    }
    
}
