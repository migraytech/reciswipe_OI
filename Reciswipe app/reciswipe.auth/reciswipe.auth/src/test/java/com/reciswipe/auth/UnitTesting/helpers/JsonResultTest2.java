package com.reciswipe.auth.UnitTesting.helpers;

import com.reciswipe.auth.helpers.ErrorCode;
import com.reciswipe.auth.helpers.JsonResult;
import com.reciswipe.auth.server.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JsonResultTest2 {

    private static JsonResult result;
    private static User user;

    @Before
    public void setup() {
        user = new User();
        result = new JsonResult();
    }

    @Test
    public void setValue() {
        user.setUsername("GenericTest");
        user.setPassword("GenericPasswordTest");
        result.setItem(user);
        result.setMessage("Successfully loggedIn");

        Assert.assertNotNull(result.getMessage());
        Assert.assertNotNull(result.getItem());
    }

    @Test
    public void setErrorCode() {
        result = new JsonResult();
        result.setErrorCode(ErrorCode.FAILED_CREATING_USER);
        result.setErrorMessage("Failed to create user");
        Assert.assertNotNull(result.getErrorEnum());
        Assert.assertEquals(ErrorCode.FAILED_CREATING_USER, result.getErrorEnum());
        Assert.assertNotNull(result.getErrorMessage());
    }
}