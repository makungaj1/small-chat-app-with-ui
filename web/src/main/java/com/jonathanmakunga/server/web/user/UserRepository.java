package com.jonathanmakunga.server.web.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDao, Long> {
    UserDao findUserByEmail(String email);
    UserDao findByEmail(String email);
}
