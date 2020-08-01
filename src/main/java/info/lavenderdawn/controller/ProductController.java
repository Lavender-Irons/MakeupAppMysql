package info.lavenderdawn.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.lavenderdawn.entities.Collection;
import info.lavenderdawn.entities.Product;
import info.lavenderdawn.services.CollectionService;
import info.lavenderdawn.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CollectionService collectionService;
	
	@GetMapping
	public String displayProducts(Model model) {
		
		Iterable<Product> products = productService.getAll();
		model.addAttribute("products", products);
		
		return "products/list-products";
		
	}
	
	@GetMapping("/new")
	public String displayProductForm(Model model) {
		
		Product aProduct = new Product();
		Iterable<Collection>collections=collectionService.getAll();
		
		model.addAttribute("product", aProduct);
		model.addAttribute("allCollections", collections);
		
		return "products/new-product";
	}
	
	@PostMapping("/save")
	public String createProduct(Product product, BindingResult bindingResult, @RequestParam List<Long>collections,  Model model) {
		
		productService.save(product);
		
		return "redirect:/products";
	}
	
		
		@GetMapping("delete")
		public String deleteProduct(@RequestParam("id") long theId, Model model) {
			Product thePro = productService.findByProductId(theId);
			productService.delete(thePro);
			return "redirect:/products";
		}

}