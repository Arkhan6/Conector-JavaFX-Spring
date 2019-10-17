package com.implica.implica.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    private String user; // dni

    private String pswd; // hasheado


}
