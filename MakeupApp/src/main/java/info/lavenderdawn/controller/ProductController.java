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

import info.lavenderdawn.dao.CollectionRepository;
import info.lavenderdawn.dao.ProductRepository;
import info.lavenderdawn.entities.Collection;
import info.lavenderdawn.entities.Product;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CollectionRepository collectionRepository;
	
	@GetMapping
	public String displayProducts(Model model) {
		
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		
		return "products/list-products";
		
	}
	
	@GetMapping("/new")
	public String displayProductForm(Model model) {
		
		Product aProduct = new Product();
		List<Collection>collections=collectionRepository.findAll();
		
		model.addAttribute("product", aProduct);
		model.addAttribute("allCollections", collections);
		
		return "products/new-product";
	}
	
	@PostMapping("/save")
	public String createProduct(Product product, BindingResult bindingResult, @RequestParam List<Long>collections,  Model model) {
		
		productRepository.save(product);
		
		return "redirect:/products";
	}
	
	@GetMapping("/update")
	public String displayProductUpdateForm(@RequestParam("id")long theId, Model model) {
		
		Product thePro = productRepository.findByProductId(theId);
		model.addAttribute("product", thePro);
		
		return "products/new-product";
	}
	
	@GetMapping("delete")
	public String deleteProduct(@RequestParam("id") long theId, Model model) {
		
		Product thePro = productRepository.findByProductId(theId);
		productRepository.delete(thePro);
		
		return "redirect:/products";
	}
}
	