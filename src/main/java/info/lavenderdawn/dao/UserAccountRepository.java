package info.lavenderdawn.dao;


import org.springframework.data.repository.PagingAndSortingRepository;

import info.lavenderdawn.entities.UserAccount;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long>{

}