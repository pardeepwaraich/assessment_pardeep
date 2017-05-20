package com.pardeep.service;

import com.pardeep.model.User;

import java.util.List;

public interface UserService {
  User save(User user);
  void deleteAllUsers();
  Iterable<User> getUsers();
  User getUserByUsername(String userName);
}
