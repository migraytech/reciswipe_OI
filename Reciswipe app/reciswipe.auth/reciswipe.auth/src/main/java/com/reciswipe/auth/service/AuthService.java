package com.reciswipe.auth.service;
import com.reciswipe.auth.interfaces.IUserService;
import com.reciswipe.auth.interfaces.IValidator;
import com.reciswipe.auth.repository.AuthRepository;
import com.reciswipe.auth.server.domain.User;
import com.reciswipe.auth.validators.UserValidator;
import org.hibernate.HibernateException;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.reciswipe.auth.helpers.Logger.log;


@Service
public class AuthService implements IUserService, IValidator {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    @Lazy
    private UserValidator userValidator;

    @Autowired
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User findAllByUsername(String username) {
        return authRepository.findAllByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = authRepository.findAllByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_" + user.getRole());
        // The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
        // And used by auth manager to verify and check user authentication.
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), grantedAuthorities);  }

    @Override
    public User findUserById(long user_id) {
        return authRepository.findUserById(user_id);
    }

    @Override
    public User login(User user) {
        try {
            User retrieved = findAllByUsername(user.getUsername());
            if (retrieved != null) {
                if (getEncoder().matches(user.getPassword(), retrieved.getPassword())) {
                    return userValidator.sanitize(findUserById(retrieved.getId()));
                } else {
                    throw new IllegalArgumentException("Wrong password");
                }
            }
            return null;
        } catch (Exception e) {
            log(this.getClass(), "Error while logging with the user: " + user.getUsername());
            log(this.getClass(), true, e);
            throw e;
        }
    }

    @Override
    public User save(User user) {
        try {
            authRepository.save(user);
            return user;
        } catch (HibernateException ex) {
            log(this.getClass(), "Error while creating the account: " + user.getUsername());
            log(this.getClass(), true, ex);
            throw ex;
        }
    }

    @Override
    public User create(User user) {
        return null;
    }


    @Override
    public List<User> read() {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

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
