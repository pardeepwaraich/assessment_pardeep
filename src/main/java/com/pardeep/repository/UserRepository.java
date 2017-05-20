package com.pardeep.repository;

import com.pardeep.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {

  User getUserByUserName(String username);
}
