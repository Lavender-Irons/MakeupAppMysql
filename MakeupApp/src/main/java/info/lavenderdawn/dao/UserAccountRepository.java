package info.lavenderdawn.dao;

import org.springframework.data.repository.CrudRepository;

import info.lavenderdawn.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{

}
