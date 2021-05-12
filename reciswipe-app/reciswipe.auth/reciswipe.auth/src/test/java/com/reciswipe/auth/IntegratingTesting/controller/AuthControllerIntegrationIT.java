package com.reciswipe.auth.IntegratingTesting.controller;

import com.reciswipe.auth.server.controller.AuthController;
import org.junit.jupiter.api.Disabled;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//@RunWith(SpringRunner.class)
//@ContextConfiguration(locations ="classpath*:/spring/test-context.xml")
//@WebMvcTest(AuthController.class)
//@Disabled
public class AuthControllerIntegrationIT {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private UserService userService;
//
//    private static ObjectMapper mapper;
//
//    private static User user;
//
//    @Before
//    public void setup() {
//        user = new User();
//        mapper = new ObjectMapper();
//    }
//
//
//    public void createUser(String username, String password) {
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setRole("USER");
//        Mockito.when(userService.create(user)).thenReturn(user);
//
//    }
//
//    @Disabled
//    @Test
//    public void createUserWhenReturnUserThatCreated() throws Exception {
//
//        this.createUser("GenericUsernameTest","GenericPasswordTest");
//
//        String json = mapper.writeValueAsString(user);
//        mvc.perform(post("/auth/signUp")
//                .content(json)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect((ResultMatcher) jsonPath("$[0].username", is("GenericUsernameTest")));
//
//    }


}
