package com.implica.implica.web.rest;

import com.implica.implica.domain.User;
import com.implica.implica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRest {

    @Autowired UserService userService;


    @PostMapping("/public/users/login")
    public ResponseEntity<User> postLogin(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(username, password));
    }

    @PostMapping("/public/users/register")
    public ResponseEntity<User> postRegister(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(username, password));
    }

}
