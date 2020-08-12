package info.lavenderdawn.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import info.lavenderdawn.entities.Shopping;


public interface ShoppingRepository extends CrudRepository<Shopping, Long>{

	Iterable<Shopping> findAll(Pageable pageAndSize);

	@Override
	public List<Shopping>findAll();

	public Shopping findByShoppingId(long theId);
}
