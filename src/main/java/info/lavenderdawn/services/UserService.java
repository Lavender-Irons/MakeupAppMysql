package info.lavenderdawn.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import info.lavenderdawn.dto.UserRegistrationDto;
import info.lavenderdawn.entities.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}