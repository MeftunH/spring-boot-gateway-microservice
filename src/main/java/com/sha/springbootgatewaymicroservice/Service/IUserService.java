package com.sha.springbootgatewaymicroservice.Service;

import com.sha.springbootgatewaymicroservice.Model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    List<User> findAll();
}
