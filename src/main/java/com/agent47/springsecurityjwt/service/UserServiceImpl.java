package com.agent47.springsecurityjwt.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.agent47.springsecurityjwt.model.User;
import com.agent47.springsecurityjwt.repo.UserRepo;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder pwdEncoder;

    @Override
    public Integer saveUser(User user) {
        // Encode password
        user.setPassword(pwdEncoder.encode(user.getPassword()));

        return userRepo.save(user).getId();
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> findUserByUsername = findUserByUsername(username);

        if(findUserByUsername.isEmpty())
        throw new UnsupportedOperationException("User not exist");

        User user = findUserByUsername.get();

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
        user.getRoles().stream()
        .map(role->new SimpleGrantedAuthority(role))
        .collect(Collectors.toList()) ); 
    }
}
