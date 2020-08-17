package info.lavenderdawn.services;

import org.springframework.stereotype.Service;

import info.lavenderdawn.entities.ProductScan;



@Service
public interface ProductScanService {

	Iterable<ProductScan> findAll();
	
	

}
