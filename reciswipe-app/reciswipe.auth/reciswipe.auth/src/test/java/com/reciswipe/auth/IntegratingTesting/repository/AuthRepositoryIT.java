package com.reciswipe.auth.IntegratingTesting.repository;

import com.reciswipe.auth.repository.AuthRepository;
import com.reciswipe.auth.server.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthRepositoryIT {

    @Autowired
    private AuthRepository userRepository;

    private static User user;

    @Before
    public void setup() {
        user = new User();
    }

    @Test
    public void injectedComponentsAreNotNull() {
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void whenSaved_thenFindsByName() {
        user.setUsername("GenericUserNameTest");
        user.setId(1l);
        user.setPassword("GenericPasswordTest");
        user.setRole("ADMIN");
        userRepository.save(user);
        User findUser = userRepository.findAllByUsername("GenericUserNameTest");
        Assert.assertNotNull(findUser);
    }

    @Test
    public void whenSaved_thenFindUserById() {
        user.setUsername("GenericUserNameTest2");
        user.setId(2l);
        user.setPassword("GenericPasswordTest2");
        user.setRole("USER");
        userRepository.save(user);
        User findUser = userRepository.findUserById(user.getId());
        Assert.assertNotNull(findUser);
    }


}
