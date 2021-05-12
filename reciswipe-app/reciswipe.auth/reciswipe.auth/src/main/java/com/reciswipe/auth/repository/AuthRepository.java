package com.reciswipe.auth.repository;

import com.reciswipe.auth.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User,Long> {

    User findAllByUsername(String username);
    User findUserById(long user_id);
}
