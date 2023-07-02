package com.agent47.springsecurityjwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agent47.springsecurityjwt.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    
}
