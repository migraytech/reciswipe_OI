package com.reciswipe.auth.UnitTesting.validators;

import com.reciswipe.auth.server.domain.User;
import com.reciswipe.auth.validators.UserValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserValidationTest {

    private static UserValidator userValidator;
    private static User user;


    @Before
    public void setUpUser() {
        userValidator = new UserValidator();
        user = new User();
        user.setUsername("GenericUserNameTest");
        user.setId(0l);
        user.setRole("ADMIN");
        user.setPassword("GenericPasswordTest");
    }


    @Test
    public void checkValidationMethodeUsername()
    {
        userValidator.validationUser(user);
    }

    @Test
    public void checkValidationCreateUser()
    {
        boolean IsValid = userValidator.validCreateUser(user);
        Assert.assertTrue("CreateUser is not validate",IsValid);
    }

    @Test
    public void checkValidationLoginUser() {
        boolean IsValid = userValidator.validLoginUser(user);
        Assert.assertTrue("LoginUser is validate",IsValid);

    }

    @Test(expected = NullPointerException.class)
    public void  UserIsNullSoValidationReturnFalseCreateUserByNullPointerException() {
        user = new User();
        userValidator.validCreateUser(user);
    }

    @Test(expected = NullPointerException.class)
    public void  UserIsNullSoValidationReturnFalseLoginUserByNullPointerException() {
        user = new User();
        userValidator.validLoginUser(user);
    }

    @Test(expected = NullPointerException.class)
    public void  UserIsNullSoValidationMethodeByNullPointerException() {
        user = new User();
        userValidator.validationUser(user);
    }

}
