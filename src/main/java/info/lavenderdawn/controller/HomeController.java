package info.lavenderdawn.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import info.lavenderdawn.dao.ProductRepository;
import info.lavenderdawn.dto.CollectionProduct;
import info.lavenderdawn.services.ProductService;

@Controller
public class HomeController {

	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService productService;
	

	@GetMapping("/")
	public String listProducts(Model model) {
		
		List<CollectionProduct>collectionProducts = productRepository.collectionProducts();
		model.addAttribute("CollectionProduct", collectionProducts);
		
		return "main/home";
	}
	
	 
	 @GetMapping("/login")
	    public String login(Model model) {
	        return "login";
	    }

	    @GetMapping("/user")
	    public String userIndex() {
	        return "user/index";
	    }
}
