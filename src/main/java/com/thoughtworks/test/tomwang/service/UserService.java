package com.thoughtworks.test.tomwang.service;

import com.thoughtworks.test.tomwang.model.User;
import com.thoughtworks.test.tomwang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOneById(Integer id) {
        return userRepository.findOneById(id);
    }

    public List<User> deleteOneById(Integer id) {
         return userRepository.deleteOneById(id);
    }
}
