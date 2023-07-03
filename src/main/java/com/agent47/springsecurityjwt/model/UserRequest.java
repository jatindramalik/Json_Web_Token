package com.agent47.springsecurityjwt.model;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String password;
}
