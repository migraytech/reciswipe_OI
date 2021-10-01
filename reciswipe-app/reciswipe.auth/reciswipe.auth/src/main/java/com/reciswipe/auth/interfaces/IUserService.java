package com.reciswipe.auth.interfaces;

import com.reciswipe.auth.server.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserService extends IGenericService <User> {

    User findAllByUsername(String username);
    UserDetails loadUserByUsername(String username);
    User findUserById(long user_id);
    User login(User user);
    User save(User user);

    @Override
    User create(User user);

    @Override
    List<User> read();

    @Override
    User update(User user);

    @Override
    boolean delete(User user);
}

