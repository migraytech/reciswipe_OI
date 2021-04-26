package com.reciswipe.auth.validators;

import com.reciswipe.auth.interfaces.IValidator;
import com.reciswipe.auth.server.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class UserValidator implements IValidator {


    @Override
    public void validationUser(User user) {
        if (user.getUsername() == null || user.getUsername().equals("")) {
            throw new NullPointerException("Username wasn't filled");
        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            throw new NullPointerException("Password wasn't filled");
        }
    }

    @Override
    public boolean validLoginUser(User user) {
        validationUser(user);
        if (user.getId() != 0) {
            throw new IllegalArgumentException("Id is not allowed to be filled during login");
        }
        return true;
    }

    @Override
    public boolean validCreateUser(User user) {
        if (user.getUsername() == null || user.getUsername().equals("")) {
            throw new NullPointerException("Username wasn't filled");
        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            throw new NullPointerException("Password wasn't filled");
        }
        return true;
    }

    @Override
    public User sanitize(User user) {
        if(user !=  null){
            user.setPassword(" ");
        }
        return user;
    }
}
