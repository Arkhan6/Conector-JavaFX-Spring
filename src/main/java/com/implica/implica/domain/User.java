package com.implica.implica.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user")
    private String username; // dni

    @Column(name = "pswd")
    private String password; // hasheado


}
