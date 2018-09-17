package com.thoughtworks.test.tomwang.repository;

import com.thoughtworks.test.tomwang.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    User findOneById(Integer id);
}
