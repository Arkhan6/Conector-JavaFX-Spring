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
        user.setPswd(BCrypt.hashpw(user.getPswd(), BCrypt.gensalt()));
        return userRepository.save(user);
    }


    public User login(String username, String password) {
        if (!userRepository.existsById(username)) {
            throw new RuntimeException("No existe el usuario");
        }

        User user = userRepository.getOne(username);

        if (BCrypt.checkpw(password, user.getPswd())) {
            return user;
        } else {
            throw new RuntimeException("Password no valido");
        }
    }

}
