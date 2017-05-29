package com.repository;

import com.model.City;
import com.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by inastase on 11/23/2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
    User findByUsernameAndPassword(String username, String password);

}
