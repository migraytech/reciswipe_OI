package com.reciswipe.auth.UnitTesting.helpers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciswipe.auth.helpers.JsonLogic;
import com.reciswipe.auth.server.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JsonLogicTest {
    private static JsonLogic logic;
    private static ObjectMapper mapper;

    @Before
    public void setup() {
        mapper = new ObjectMapper();
        logic = new JsonLogic();
    }

    private void notNullAccount(User user) {
        assertNotNull(user);
        assertNotNull(user.getUsername());
        assertNotNull(user.getPassword());
    }

    private void matchAccount(User expected, User actual) {
        notNullAccount(expected);
        notNullAccount(actual);
        assertEquals(expected.getUsername(), actual.getUsername());
    }

    @Test
    public void getObject() throws JsonProcessingException {
        User user = new User();
        user.setPassword("PassGenericTest");
        user.setUsername("UserGenericTest");
        String json = mapper.writeValueAsString(user);
        User logicUser = (User) JsonLogic.getObject(User.class, json);
        matchAccount(user, logicUser);
    }
}
