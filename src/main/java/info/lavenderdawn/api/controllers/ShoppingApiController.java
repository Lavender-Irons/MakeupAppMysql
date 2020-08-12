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

import info.lavenderdawn.dao.ShoppingRepository;
import info.lavenderdawn.entities.Shopping;

@RestController
@RequestMapping("/app-api/shoppings")
public class ShoppingApiController {
	
	@Autowired
	ShoppingRepository shoppingRepository;
	
	@GetMapping
	public Iterable<Shopping>getShoppings(){
		return shoppingRepository.findAll();
	}

	@GetMapping("/{id}")
	public Shopping getShoppingById(@PathVariable("id") Long id) {
		return shoppingRepository.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Shopping create(@RequestBody @Valid Shopping shopping) {
		return shoppingRepository.save(shopping);
	}
	
	@PutMapping(consumes= "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Shopping update(@RequestBody @Valid Shopping shopping) {
		return shoppingRepository.save(shopping);
	}
	
	@PatchMapping(path= "/{id}", consumes= "application/json")
	public Shopping partialUpdate(@PathVariable("id") long id, @RequestBody @Valid Shopping patchShopping) {
		Shopping shopping = shoppingRepository.findById(id).get();
		
		if(patchShopping.getCategory() !=null) {
			shopping.setCategory(patchShopping.getCategory());
		}
		
		if(patchShopping.getName() !=null) {
			shopping.setName(patchShopping.getName());
		}
		
		if(patchShopping.getBrand() !=null) {
			shopping.setBrand(patchShopping.getBrand());
		}
		
		if(patchShopping.getColor() !=null) {
			shopping.setColor(patchShopping.getColor());
		}
		
		if(patchShopping.getCost() !=0) {
			shopping.setCost(patchShopping.getCost());
		}
		
		if(patchShopping.getAmount() !=0) {
			shopping.setAmount(patchShopping.getAmount());
		}
		
		if(patchShopping.getBought() !=null) {
			shopping.setBought(patchShopping.getBought());
		}
		return shoppingRepository.save(shopping);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			shoppingRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			
		}
	}
		
		@GetMapping(params = {"page", "size"})
		@ResponseStatus(HttpStatus.OK)
		public Iterable<Shopping>findPaginatedShoppings(@RequestParam("page") int page,
				@RequestParam("size") int size){
				Pageable pageAndSize = PageRequest.of(page, size);
				
				return shoppingRepository.findAll(pageAndSize);
		
	}
}
