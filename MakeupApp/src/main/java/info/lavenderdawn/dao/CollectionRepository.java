package info.lavenderdawn.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import info.lavenderdawn.entities.Collection;

public interface CollectionRepository extends CrudRepository<Collection, Long>{
		
	
	@Override
	public List<Collection>findAll();
	
	public Collection findByCollectionId(long theId);

}

