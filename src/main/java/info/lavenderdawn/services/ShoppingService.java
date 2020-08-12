package info.lavenderdawn.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.lavenderdawn.dao.ShoppingRepository;
import info.lavenderdawn.entities.Shopping;

@Service
public class ShoppingService {

	@Autowired
	ShoppingRepository shoppingRepository;

	public Iterable<Shopping> getAll() {
		return shoppingRepository.findAll();
	
	}

	public Shopping save(Shopping shopping) {
		return shoppingRepository.save(shopping);
	}

	public Shopping findByShoppingId(long theId) {
		return shoppingRepository.findByShoppingId(theId);
	}

	public void delete(Shopping theShopping) {
		shoppingRepository.delete(theShopping);
		
	}
		
	
}
