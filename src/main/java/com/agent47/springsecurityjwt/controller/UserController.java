package com.agent47.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agent47.springsecurityjwt.model.User;
import com.agent47.springsecurityjwt.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        String body = null;
        try{
        Integer id = userService.saveUser(user);
        body = "User '" + id + "'saved";
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(body);

    }
    @GetMapping("/welcome")
    public String welcome(){
        return "u r welcome";
    }

}
