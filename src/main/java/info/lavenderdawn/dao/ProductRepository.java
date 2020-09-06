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
	
	@Query(nativeQuery=true, value="SELECT collection.category, product.name, product.brand, product.color, product.cost, product.amount, product.rating " + 
			"FROM collection " + 
			"JOIN collection_product ON collection.collection_id = collection_product.collection_id " + 
			"JOIN product ON product.product_id = collection_product.product_id " + 
			"WHERE collection.category = 'primer' OR collection.category='foundation' OR collection.category='powder' OR collection.category='contour' ")
			public List<CollectionProduct>collectionFoundation();
	
	@Query(nativeQuery=true, value="SELECT collection.category, product.name, product.brand, product.color, product.cost, product.amount, product.rating " + 
			"FROM collection " + 
			"JOIN collection_product ON collection.collection_id = collection_product.collection_id " + 
			"JOIN product ON product.product_id = collection_product.product_id " + 
			"WHERE collection.category = 'eye shadow' OR collection.category='eyeliner' OR collection.category='mascara' OR collection.category='eyebrow' ")
			public List<CollectionProduct>collectionEyes();
	
	@Query(nativeQuery=true, value="SELECT collection.category, product.name, product.brand, product.color, product.cost, product.amount, product.rating " + 
			"FROM collection " + 
			"JOIN collection_product ON collection.collection_id = collection_product.collection_id " + 
			"JOIN product ON product.product_id = collection_product.product_id " + 
			"WHERE collection.category = 'blush'  ")
			public List<CollectionProduct>collectionBlush();
	
	@Query(nativeQuery=true, value="SELECT collection.category, product.name, product.brand, product.color, product.cost, product.amount, product.rating " + 
			"FROM collection " + 
			"JOIN collection_product ON collection.collection_id = collection_product.collection_id " + 
			"JOIN product ON product.product_id = collection_product.product_id " + 
			"WHERE collection.category = 'lipliner'  OR collection.category = 'lipliner' ")
			public List<CollectionProduct>collectionLips();
	
	public Iterable<Product> findAll(Pageable pageAndSize);

	public Product findByProductId(long theId);

	

}