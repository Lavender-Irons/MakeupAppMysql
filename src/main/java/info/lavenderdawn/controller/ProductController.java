package info.lavenderdawn.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.lavenderdawn.entities.Collection;
import info.lavenderdawn.entities.Product;
import info.lavenderdawn.entities.ZXingHelper;
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
		
		try {
			productService.save(product);
		}
		catch(DataIntegrityViolationException e) {
			System.out.println("Product already exists!");
		}
		
		return "redirect:/products";
	}
	
		@GetMapping("delete")
		public String deleteProduct(@RequestParam("id") long theId, Model model) {
			Product thePro = productService.findByProductId(theId);
			productService.delete(thePro);
			return "redirect:/products";
		}

		@GetMapping(value= "barcode/{id}")
		public void barcode (@PathVariable("id") String id, HttpServletResponse response) throws Exception {
			response.setContentType("image/png");
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(ZXingHelper.getBarCodeImage(id, 200, 200));
			outputStream.flush();
			outputStream.close();
			
		}
}