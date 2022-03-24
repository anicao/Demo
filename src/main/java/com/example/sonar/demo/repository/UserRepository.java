package com.example.sonar.demo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.sonar.demo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
  
  List<User> findByName(String name);
  User findOneByName(String name);

}
