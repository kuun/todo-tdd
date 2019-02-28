package org.tdd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.tdd.pojo.Todo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {
    public static final String TODO_TITLE = "Buy dog food";
    public static final String POST_URL = "/todo";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testCreatePost_returnSuccess() throws Exception {
        ResultActions resultActions = sendCreateTodoRequest(TODO_TITLE);

        checkCreateValidTodoResult(resultActions);
    }

    private ResultActions sendCreateTodoRequest(String todoTitle) throws Exception {
        Todo buyDogFood = new Todo(todoTitle);
        return mockMvc.perform(post(POST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(buyDogFood)));
    }

    private void checkCreateValidTodoResult(ResultActions resultActions) throws Exception {
        resultActions.andExpect(status().isCreated());
        Todo output = transferResponse2Todo(resultActions);


        Assert.assertNotNull(output);
        Assert.assertEquals(0, output.getId());
        Assert.assertEquals(TODO_TITLE, output.getTitle());
    }

    private Todo transferResponse2Todo(ResultActions resultActions) throws java.io.IOException {
        String response = resultActions.andReturn().getResponse().getContentAsString();
        return objectMapper.readValue(response, Todo.class);
    }


}
