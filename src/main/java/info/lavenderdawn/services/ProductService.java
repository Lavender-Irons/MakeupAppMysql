package info.lavenderdawn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.lavenderdawn.dao.CollectionRepository;
import info.lavenderdawn.dao.ProductRepository;
import info.lavenderdawn.dto.CollectionProduct;
import info.lavenderdawn.entities.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CollectionRepository collectionRepository;

	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Iterable<Product>getAll(){
		return productRepository.findAll();
	}

	public List<CollectionProduct>collectionProduct(){
		return productRepository.collectionProducts();
	}
	
	public Product findByProductId(long theId) {
		return productRepository.findByProductId(theId);
	}
	public void delete(Product thePro) {
		productRepository.delete(thePro);
	}
}
