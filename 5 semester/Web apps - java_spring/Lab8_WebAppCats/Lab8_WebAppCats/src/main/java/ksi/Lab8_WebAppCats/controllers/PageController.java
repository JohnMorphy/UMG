package ksi.Lab8_WebAppCats.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ksi.Lab8_WebAppCats.repositories.CatRepository;
import ksi.Lab8_WebAppCats.models.*;
import ksi.Lab8_WebAppCats.exceptions.*;


@Controller
class PageController {
	
	private final CatRepository repository;
	
	PageController(CatRepository repository) {
		this.repository = repository;
	}
 
	@GetMapping("/")
	public String index(Model model) {
	    List<Cat> cats = repository.findAll();
	    model.addAttribute("cats", cats);

	    return "index";
	}
	
}