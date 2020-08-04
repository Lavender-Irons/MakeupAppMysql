package info.lavenderdawn.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import info.lavenderdawn.dao.CollectionRepository;
import info.lavenderdawn.entities.Collection;

@RestController
@RequestMapping("/app-api/collections")
public class CollectionApiController {
	
	@Autowired
	CollectionRepository collectionRepository;
	
	@GetMapping
	public Iterable<Collection> getCollections(){
		return collectionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Collection getCollectionById(@PathVariable("id") Long id) {
		return collectionRepository.findById(id).get();
	}
	
	@PostMapping(consumes = "applicatoin/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Collection create(@RequestBody @Valid Collection collection) {
		return collectionRepository.save(collection);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Collection update(@RequestBody @Valid Collection collection) {
		return collectionRepository.save(collection);
	}
	
	@PatchMapping(path= "/{id}", consumes= "application/json")
	public Collection partialUpdate(@PathVariable("id") long id, @RequestBody @Valid Collection patchCollection) {
		Collection col = collectionRepository.findById(id).get();
		
			if(patchCollection.getCollections() != null) {
				col.setCategory(patchCollection.getCategory());
			}
			
		return collectionRepository.save(col);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			collectionRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
		}
	}
}