package com.implica.implica.repository;

import com.implica.implica.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

//    boolean existsByUser(String user);

}
