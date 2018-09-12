package com.thoughtworks.test.tomwang.repository;

import com.thoughtworks.test.tomwang.model.Son;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SonRepository extends JpaRepository <Son,Integer>{
}
