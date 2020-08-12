package info.lavenderdawn.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import info.lavenderdawn.dao.ProductRepository;
import info.lavenderdawn.entities.Product;

@RestController
@RequestMapping("/app-api/products")
public class ProductApiController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping
	public Iterable<Product> getProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return productRepository.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody @Valid Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Product update(@RequestBody @Valid Product product) {
		return productRepository.save(product);
	}
	
	@PatchMapping(path="/{id}", consumes = "application/json")
	public Product partialUpdate(@PathVariable("id") long id, @RequestBody Product patchProduct) {
		Product pro = productRepository.findById(id).get();
		
		if(patchProduct.getName() != null) {
			pro.setName(patchProduct.getName());
		}
		if(patchProduct.getBrand() != null) {
			pro.setBrand(patchProduct.getBrand());
		}
		if(patchProduct.getColor() != null) {
			pro.setColor(patchProduct.getColor());
		}
		if(patchProduct.getCost() != 0) {
			pro.setCost(patchProduct.getCost());
		}
		if(patchProduct.getAmount() !=0) {
			pro.setAmount(patchProduct.getAmount());
		}
		if(patchProduct.getRating() != 0) {
			pro.setRating(patchProduct.getRating());
		}
		return productRepository.save(pro);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
		productRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			
		}
	}
	
	@GetMapping(params= {"page", "size"})
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Product> findPaginatedEmployees(@RequestParam("page") int page, 
			@RequestParam("size") int size){
			Pageable pageAndSize = PageRequest.of(page, size);
			
			return productRepository.findAll(pageAndSize);
		
	}
}
