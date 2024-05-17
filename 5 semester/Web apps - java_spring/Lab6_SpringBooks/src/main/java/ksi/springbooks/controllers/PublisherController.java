package ksi.springbooks.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ksi.springbooks.models.Publisher;
import ksi.springbooks.services.PublisherService;

@Controller
public class PublisherController {

	@Autowired
	private PublisherService service;
	
	public PublisherController() {}
	
	@RequestMapping("publisher_list")
	public String viewCategoryList(Model model){
		List<Publisher> lp=service.findAll();
		model.addAttribute("lp", lp);
		return "publisher_list";
	}
	
	@RequestMapping("/new_publisher")
	public String showFormNewPublisher(Model model) {
		Publisher np = new Publisher();
		model.addAttribute("publisher", np);
		return "new_publisher";
	}
	
	@PostMapping(value="/save_publisher")
	public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
		service.save(publisher);
		return "redirect:/publisher_list";
	}

	@RequestMapping("/edit_publisher/{idp}")
	public ModelAndView showEditFormPublisher(@PathVariable(name = "idp") Long idp) {
		ModelAndView mav = new ModelAndView("edit_publisher");
		Optional<Publisher> eb = service.findById(idp);
		mav.addObject("publisher", eb);
		return mav;
	}
	
	@RequestMapping("/delete_publisher/{idp}")
	public String deletePublisher(@PathVariable(name = "idp") Long idp) {
		
		
		// deletion only possible if category not assigned to any book
		if(service.findById(idp) != null && service.findById(idp).get().getBooks().size() > 0) {
			return "page500";
		} else {
			service.deleteById(idp);
			return "redirect:/publisher_list";
		}
		
		
	}
	
}
