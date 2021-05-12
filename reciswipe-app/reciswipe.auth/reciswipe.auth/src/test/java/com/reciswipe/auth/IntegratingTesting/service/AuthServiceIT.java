package com.reciswipe.auth.IntegratingTesting.service;

import com.reciswipe.auth.repository.AuthRepository;
import com.reciswipe.auth.server.domain.User;
import com.reciswipe.auth.service.AuthService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthServiceIT {

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {
        @Bean
        public AuthService authService() {
            return new AuthService();
        }
    }

    @Autowired
    private AuthService authService;

    @MockBean
    public AuthRepository userRepository;

    private static User user;


    @Before
    public void whenSaved_thenFindsByNameForMock() {
        user = new User();
        user.setUsername("GenericUserNameTest");
        user.setId(2l);
        user.setPassword("GenericPasswordTest");
        user.setRole("ADMIN");

        Mockito.when(userRepository.findAllByUsername(user.getUsername()))
                .thenReturn(user);

        Mockito.when(userRepository.findUserById(user.getId()))
                .thenReturn(user);
    }

    @Test
    public void whenValidUserName_thenUserShouldBeFound() {
        String name = user.getUsername();
        User found = authService.findAllByUsername(name);
        Assert.assertEquals(found.getUsername().trim(), name.trim());
    }

    @Test
    public void whenValidId_thenUserShouldBeFound() {
        long userId = user.getId();
        String name = user.getUsername();
        User found = authService.findUserById(userId);
        Assert.assertEquals(found.getUsername().trim(), name.trim());
    }
}