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

import ksi.springbooks.models.Book;
import ksi.springbooks.models.Category;
import ksi.springbooks.models.Publisher;
import ksi.springbooks.services.BookService;
import ksi.springbooks.services.CategoryService;
import ksi.springbooks.services.PublisherService;

@Controller
public class BookController {

	@Autowired
	private BookService service;
	
	@Autowired
	private CategoryService categories;
	
	@Autowired
	private PublisherService publishers;
	
	public BookController() {}

	@RequestMapping("books_list_sort")
	public String viewBooksListSorted(Model model){
		List<Book> lb=service.findAlByCategoryAndTitle();
		model.addAttribute("lb", lb);
		return "books_list";
	}
	
	@RequestMapping("books_list")
	public String viewBooksList(Model model){
		List<Book> lb=service.findAll();
		model.addAttribute("lb", lb);
		return "books_list";
	}
	
	@RequestMapping("/new_book")
	public String showFormNewBook(Model model) {
		Book nb = new Book();
		List<Category> availableCategories = categories.findAll();
		List<Publisher> availablePublishers = publishers.findAll();
		model.addAttribute("book", nb);
		model.addAttribute("categories", availableCategories);
		model.addAttribute("publishers", availablePublishers);
		return "new_book";
	}
	
	@PostMapping(value="/save_book")
	public String saveBook(@ModelAttribute("book") Book book) {
		service.save(book);
		return "redirect:/books_list";
	}

	@RequestMapping("/edit_book/{idb}")
	public ModelAndView showEditFormBook(@PathVariable(name = "idb") Long idb) {
		ModelAndView mav = new ModelAndView("edit_book");
		Optional<Book> eb = service.findById(idb);
		mav.addObject("book", eb);
		
		List<Category> availableCategories = categories.findAll();
		List<Publisher> availablePublishers = publishers.findAll();
		mav.addObject("categories", availableCategories);
		mav.addObject("publishers", availablePublishers);
		
		return mav;
	}

	@RequestMapping("/delete_book/{idb}")
	public String deleteBook(@PathVariable(name = "idb") Long idb) {
		service.deleteById(idb);
		return "redirect:/books_list";
	}

	
}