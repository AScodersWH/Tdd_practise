package com.thoughtworks.test.tomwang.repository;

import com.thoughtworks.test.tomwang.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @MockBean
    private UserRepository userRepository;


    @Before
    public void set_User() {
        User user1 = new User();
        user1.setId(1);
        user1.setUserName("2313");
        User user2 = new User();
        user2.setId(2);
        user2.setUserName("23131231");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        Mockito.when(userRepository.findAll()).thenReturn(users);
        Mockito.when(userRepository.findOneById(1)).thenReturn(user1);
        Mockito.when(userRepository.findOneById(2)).thenReturn(user2);

    }

    @Test
    public void should_return_users_successfully() {
        User user1 = new User();
        user1.setId(1);
        user1.setUserName("2313");
        User user2 = new User();
        user2.setId(2);
        user2.setUserName("23131231");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        assertEquals(userRepository.findAll(), users);

    }

    @Test
    public void should_return_user1_successfully() {
        User user1 = new User();
        user1.setId(1);
        user1.setUserName("2313");
        assertEquals(userRepository.findOneById(1),user1);
    }

    @After
    public void reset_User() {
        Mockito.reset(userRepository);
    }
}