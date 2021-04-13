package com.reciswipe.auth.interfaces;

import com.reciswipe.auth.server.domain.User;

public interface IValidator {

    void validationUser(User user);
    boolean validLoginUser(User user);
    boolean validCreateUser(User user);
    User sanitize(User user);
}
