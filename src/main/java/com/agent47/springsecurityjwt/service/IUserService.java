package com.agent47.springsecurityjwt.service;

import com.agent47.springsecurityjwt.model.User;

public interface IUserService {
    
    Integer saveUser(User user);
}
