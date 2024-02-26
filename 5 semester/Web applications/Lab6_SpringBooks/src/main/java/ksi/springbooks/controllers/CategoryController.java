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

import ksi.springbooks.models.Category;
import ksi.springbooks.services.CategoryService;

@Controller
public class CategoryController {


	@Autowired
	private CategoryService service;
	
	public CategoryController() {}
	
	@RequestMapping("category_list")
	public String viewCategoryList(Model model){
		List<Category> lc=service.findAll();
		model.addAttribute("lc", lc);
		return "category_list";
	}
	
	@RequestMapping("/new_category")
	public String showFormNewCategory(Model model) {
		Category nc = new Category();
		model.addAttribute("category", nc);
		return "new_category";
	}
	
	@PostMapping(value="/save_category")
	public String saveCategory(@ModelAttribute("category") Category category) {
		service.save(category);
		return "redirect:/category_list";
	}

	
	@RequestMapping("/edit_category/{idc}")
	public ModelAndView showEditFormCategory(@PathVariable(name = "idc") Long idc) {
		ModelAndView mav = new ModelAndView("edit_category");
		Optional<Category> eb = service.findById(idc);
		mav.addObject("category", eb);
		return mav;
	}

	
	@RequestMapping("/delete_category/{idc}")
	public String deleteCategory(@PathVariable(name = "idc") Long idc) {
		
		// deletion only possible if category not assigned to any book
		if(service.findById(idc) != null && service.findById(idc).get().getBooks().size() > 0) {
			return "page500";
		} else {
			service.deleteById(idc);
			return "redirect:/category_list";
		}
		
	}

	
}
