package com.agent47.springsecurityjwt.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usrtab")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String username;
    private String password;
    @ElementCollection
    @CollectionTable(name="rolestab",joinColumns = @JoinColumn(name="id"))
    @Column(name = "roles")
    private Set<String> roles;
    
}
