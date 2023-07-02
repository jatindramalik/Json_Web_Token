package com.agent47.springsecurityjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agent47.springsecurityjwt.model.User;
import com.agent47.springsecurityjwt.repo.UserRepo;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Integer saveUser(User user) {
        // TODO Auto-generated method stub

        return userRepo.save(user).getId();
    }
    
}
