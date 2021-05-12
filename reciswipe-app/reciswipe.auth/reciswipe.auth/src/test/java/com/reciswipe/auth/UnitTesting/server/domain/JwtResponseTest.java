package com.reciswipe.auth.UnitTesting.server.domain;

import com.reciswipe.auth.server.domain.JwtResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtResponseTest {

    private static JwtResponse jwtResponse;

    @Before
    public void setUp() {
        String token = null;
        jwtResponse = new JwtResponse(token);
    }

    @Test
    public void setJwtResponseProperties()
    {
        String token  = jwtResponse.getToken();
        Assert.assertEquals(token,null);
    }


    @Test
    public void setJwtResponseNewTokenValue()
    {
        String OldToken = jwtResponse.getToken();
        String NewToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIZW5yeTE4IiwiZXhwIjoxNTg2OTc5MTY2LCJpYXQiOjE1ODY5NjExNjYsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdfQ.0tB5eXqms-zVkfNrd-Fut3nouTVZnYy65LD7R8MLETw7JBbAIo7nllV2No_messxjFnHoOyrRiLgv47kugj-JQ";
        jwtResponse = new JwtResponse(NewToken);
        Assert.assertNotEquals(OldToken,jwtResponse.getToken());
    }
}
