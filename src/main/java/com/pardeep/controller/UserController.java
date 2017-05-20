package com.pardeep.controller;

import com.pardeep.model.User;
import com.pardeep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Iterable<User>> getAllUsers() {
    return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{username}")
  public ResponseEntity<User> getUserByUsername(@PathVariable final String username) {
    return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
  }

  @ExceptionHandler(value = NoSuchElementException.class)
  public String elementNotFoundException() {
    return "User Not Found";
  }
}
