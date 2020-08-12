package info.lavenderdawn.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import info.lavenderdawn.entities.Collection;
import info.lavenderdawn.services.CollectionService;

@Controller
@RequestMapping("/collections")
public class CollectionController {

	@Autowired
	CollectionService collectionService;
	
	@GetMapping
	public String displayCollections(Model model) {
		
		Iterable<Collection> collections = collectionService.getAll();
		model.addAttribute("collections", collections);
		
		return "collections/list-collections";
	}
	
	@GetMapping("/new")
	public String displayCollectionForm(Model model) {
		
		Collection aCollection = new Collection();
		model.addAttribute("collection", aCollection);
		
		return "collections/new-collection";
	}
	
	@PostMapping("/save")
	public String createCollection (Collection collection, Model model) {
		
		try {
			collectionService.save(collection);
		}
		catch(DataIntegrityViolationException e) {
			System.out.println("Category already exists!");
		}
		
		return "redirect:/collections";
	}
	
}