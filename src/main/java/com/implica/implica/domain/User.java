package com.implica.implica.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @Column(name = "user")
    private String username; // dni

    @JsonIgnore
    @Column(name = "pswd")
    private String password; // hasheado


}
