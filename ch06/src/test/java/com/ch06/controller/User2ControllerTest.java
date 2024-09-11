package com.ch06.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class User2ControllerTest {

    @Autowired
    private MockMvc mockMvc;    // mvc 테스트를 위한 가상 mvc 객체

    @Test
    void list() throws Exception {

        mockMvc.perform(get("/user2/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("/user2/list"))
                .andDo(print());
    }

    @Test
    void register() throws Exception {

        for(int i=1 ; i<10 ; i++) {
            mockMvc.perform(
                            post("/user2/register")
                                    .param("uid", "abc" + i)
                                    .param("name", "테스트")
                                    .param("birth", "1990-01-01")
                                    .param("hp", "010-1234-1001")
                                    .param("addr", "부산광역시"))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/user2/list"))
                    .andDo(print());
        }

    }

    @Test
    void modify() {
    }

    @Test
    void delete() throws Exception {

        for(int i=1 ; i<10 ; i++) {
            mockMvc.perform(get("/user2/delete")
                                .param("uid", "abc" + i))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/user2/list"))
                    .andDo(print());
        }

    }
}