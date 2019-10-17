package com.implica.implica.service;

import com.implica.implica.domain.User;
import com.implica.implica.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired UserRepository userRepository;


    public User create(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        if (!userRepository.existsByUsername(username)) {
            throw new RuntimeException("No existe el usuario");
        }

        User user = userRepository.findByUsername(username);

        if (BCrypt.checkpw(password, user.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("Password no valido");
        }
    }

    public User register(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return create(user);
    }

}
