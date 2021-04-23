package com.reciswipe.auth.UnitTesting;

import com.reciswipe.auth.server.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    private static User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void setUserPropertiesUsernameAndPassword() {
        user.setUsername("GenericTestUsername");
        user.setPassword("GenericTestPassword");
        Assert.assertEquals("GenericTestUsername", user.getUsername());
        Assert.assertEquals("GenericTestPassword", user.getPassword());
    }

    @Test
    public void setUserRole() {
        user.setRole("USER");
        Assert.assertEquals("USER", user.getRole());
    }

    @Test
    public void checkUserIsNotNULL() {
        Assert.assertNotNull(user);
    }

    @Test
    public void checkIfPropertiesIsNull() {
        String password = user.getPassword();
        String username = user.getUsername();
        String role = user.getRole();

        Assert.assertNull(password);
        Assert.assertNull(username);
        Assert.assertNull(role);
    }

    @Test
    public void checkIfPropertiesIsNotNull() {
        user.setUsername("GenericTestUsername");
        user.setPassword("GenericTestPassword");
        user.setRole("USER");
        String password = user.getPassword();
        String username = user.getUsername();
        String role = user.getRole();

        Assert.assertNotNull(password);
        Assert.assertNotNull(username);
        Assert.assertNotNull(role);
    }
}
