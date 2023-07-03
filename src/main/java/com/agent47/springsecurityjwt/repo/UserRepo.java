package com.agent47.springsecurityjwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agent47.springsecurityjwt.model.User;
import java.util.List;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User,Integer>{

    Optional<User> findUserByUsername(String username);
    
}
