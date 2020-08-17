package info.lavenderdawn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.lavenderdawn.dao.ProductScanRepository;
import info.lavenderdawn.entities.ProductScan;

@Service
public class ProductScanServiceImpl implements ProductScanService{
	
	@Autowired
	private ProductScanRepository productScanRepository;

	@Override
	public Iterable<ProductScan>findAll(){
		return productScanRepository.findAll();
	}
}
