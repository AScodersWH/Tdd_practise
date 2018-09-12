package com.thoughtworks.test.tomwang.controller;

import com.thoughtworks.test.tomwang.model.User;
import com.thoughtworks.test.tomwang.repository.UserRepository;
import com.thoughtworks.test.tomwang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserApiTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserApi userApi;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void should_achieve_delete_method() throws Exception {
        mockMvc.perform(delete("/user/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void should_achieve_get_user_by_id_method() throws Exception {
        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void should_achieve_get_users_method() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void should_achieve_post_method() throws Exception {
        mockMvc.perform(post("/user")
                .param("ss","ss"))
                .andExpect(status().is4xxClientError())
                .andReturn();
    }





}