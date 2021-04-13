package com.reciswipe.auth.validators;

import com.reciswipe.auth.interfaces.IValidator;
import com.reciswipe.auth.server.domain.User;

public class UserValidator implements IValidator {


    @Override
    public void validationUser(User user) {

    }

    @Override
    public boolean validLoginUser(User user) {
        return false;
    }

    @Override
    public boolean validCreateUser(User user) {
        return false;
    }

    @Override
    public User sanitize(User user) {
        return null;
    }
}
