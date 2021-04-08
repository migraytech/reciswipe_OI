package com.reciswipe.auth.repository;

import com.reciswipe.auth.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthRepository extends JpaRepository<User,Long> {

    @Override
     List<User> findAll();

}
