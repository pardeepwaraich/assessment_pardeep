package com.pardeep.service;

import com.pardeep.model.User;
import com.pardeep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public void deleteAllUsers() {
    userRepository.deleteAll();
  }

  @Override
  public Iterable<User> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUserByUsername(String username) {
    return userRepository.getUserByUserName(username);
  }
}
