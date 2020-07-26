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
	CollectionRepository collectionRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product>getAll(){
		return productRepository.findAll();
	}
	public List<CollectionProduct>collectionProduct(){
		return productRepository.collectionProducts();
	}
	
	public Product findByCollectionId(long theId) {
		return productRepository.findByProductId(theId);
	}
	
//	public void delete (CollectionProduct theCol) {
//		productRepository.delete(theCol);
//	}

	public Product findByProductId(long theId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Product thePro) {
		// TODO Auto-generated method stub
		
	}
}
