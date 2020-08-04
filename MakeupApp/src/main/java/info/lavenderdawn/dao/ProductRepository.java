package info.lavenderdawn.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import info.lavenderdawn.dto.CollectionProduct;
import info.lavenderdawn.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	@Override
	public List<Product>findAll();
	
	@Query(nativeQuery=true, value="SELECT collection.category, product.name, product.brand, product.color, product.cost, product.amount, product.rating " +
			"FROM collection " +
			"JOIN collection_product ON collection.collection_id = collection_product.collection_id " +
			"JOIN product ON product.product_id = collection_product.product_id ")
				public List<CollectionProduct> collectionProducts();

	public Iterable<Product> findAll(Pageable pageAndSize);

	public Product findByProductId(long theId);




}