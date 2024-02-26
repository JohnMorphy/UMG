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


@RestController
class CatController {
	
	private final CatRepository repository;
	
	CatController(CatRepository repository) {
		this.repository = repository;
	}	
	
	@GetMapping("/cats")
    ResponseEntity<List<Cat>> getCats() {
        List<Cat> cats = repository.findAll();
        return ResponseEntity.ok().body(cats);
    }
 
	@GetMapping("/cats/{id}")
    ResponseEntity<Cat> getCat(@PathVariable("id") Long id) {
        Optional<Cat> cat = repository.findById(id);
        return cat.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }
 
	@GetMapping("/fun-fact")
	String getFunFact() {
		final String uri = "https://catfact.ninja/fact";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
 
	@PostMapping("/cats")
	Cat newCat(@RequestBody Cat newCat) {
		return repository.save(newCat);
	}
 
	@PutMapping("/cats/{id}")
	Cat replaceCat(@RequestBody Cat newCat, @PathVariable("id") Long id) {
		return repository.findById(id)
				.map(cat -> {
					cat.setName(newCat.getName());
					cat.setBreed(newCat.getBreed());
					return repository.save(cat);
	})
				.orElseGet(() -> {
					newCat.setId(id);
					return repository.save(newCat);
	});
	}
 
	@DeleteMapping("/cats/{id}")
	public ResponseEntity<Void> deleteCat(@PathVariable("id") Long id) {
	    if (repository.existsById(id)) {
	        repository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
 
