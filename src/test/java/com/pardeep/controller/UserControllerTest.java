package com.pardeep.controller;

import com.pardeep.model.User;
import com.pardeep.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

  @MockBean
  private UserService userService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGetAllUsers() throws Exception {
    given(this.userService.getUsers()).willReturn(buildUserDetails());
    this.mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].userName", is("pardeep")))
            .andExpect(jsonPath("$[0].email", is("pardeep@gmail.com")))
            .andExpect(jsonPath("$[0].password", is("pokeaonmebpv6")));
  }

  @Test
  public void testGetUserByUsername() throws Exception {
    given(this.userService.getUserByUsername("pardeep")).willReturn(new User("pardeep", "pardeep@gmail.com", "pokeaonmebpv6", LocalDateTime.now()));
    this.mockMvc.perform(get("/users/pardeep").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.userName", is("pardeep")))
            .andExpect(jsonPath("$.email", is("pardeep@gmail.com")))
            .andExpect(jsonPath("$.password", is("pokeaonmebpv6")));
  }

  @Test
  public void testGetUserByEmail() throws Exception {
    given(this.userService.getUsersByEmail("pardeep@gmail.com")).willReturn(new User("pardeep", "pardeep@gmail.com", "pokeaonmebpv6", LocalDateTime.now()));
    this.mockMvc.perform(get("/users?email=pardeep@gmail.com").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.userName", is("pardeep")))
            .andExpect(jsonPath("$.email", is("pardeep@gmail.com")))
            .andExpect(jsonPath("$.password", is("pokeaonmebpv6")));
  }

  private List<User> buildUserDetails() {
    List<User> users = new ArrayList<>(2);
    users.add(new User("pardeep", "pardeep@gmail.com", "pokeaonmebpv6", LocalDateTime.now()));
    users.add(new User("nellutla", "nellutla@gmail.com", "nellutlamebpv6", LocalDateTime.now()));
    return users;
  }
}
