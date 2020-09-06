package info.lavenderdawn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import info.lavenderdawn.dao.ProductRepository;
import info.lavenderdawn.dto.CollectionProduct;

@Controller
public class BlushController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/blush")
	public String listBlush(Model model) {
		
		List<CollectionProduct>collectionProducts = productRepository.collectionBlush();
		model.addAttribute("CollectionProduct", collectionProducts);
		
		return "pages/blush";
	}
}
