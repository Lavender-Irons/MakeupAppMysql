package info.lavenderdawn.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.lavenderdawn.dao.CollectionRepository;
import info.lavenderdawn.dao.ProductRepository;
import info.lavenderdawn.entities.Collection;

@Service
public class CollectionService {

	@Autowired
	CollectionRepository collectionRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public Collection save(Collection collection) {
		return collectionRepository.save(collection);
	}
	
	public Iterable<Collection> getAll(){
		return collectionRepository.findAll();
	
	}
}