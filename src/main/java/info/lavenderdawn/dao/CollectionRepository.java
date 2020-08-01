package info.lavenderdawn.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import info.lavenderdawn.entities.Collection;

@RepositoryRestResource(collectionResourceRel="apicollection", path="apicollections")
public interface CollectionRepository extends CrudRepository<Collection, Long>{
	
	

	public Collection findByCollectionId(long theId);

}