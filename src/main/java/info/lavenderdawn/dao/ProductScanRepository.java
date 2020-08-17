package info.lavenderdawn.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import info.lavenderdawn.entities.ProductScan;

@Repository("productScanRepository")
public interface ProductScanRepository extends CrudRepository<ProductScan, Long>{

}
