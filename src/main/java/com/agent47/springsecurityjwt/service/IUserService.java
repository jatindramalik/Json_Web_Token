package com.agent47.springsecurityjwt.service;

import java.util.Optional;

import com.agent47.springsecurityjwt.model.User;

public interface IUserService {

    Integer saveUser(User user);

    Optional<User> findUserByUsername(String username);

}
