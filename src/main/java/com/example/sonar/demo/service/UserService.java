package com.example.sonar.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sonar.demo.domain.User;
import com.example.sonar.demo.model.UserInsert;
import com.example.sonar.demo.model.UserUpdateResults;
import com.example.sonar.demo.repository.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository user;
  
  public List<User> findUsers(String name) {
    try {
      if (name.isEmpty()) {
        return user.findAll();
      } else {
        
        return user.findByName(name);
      }
    } catch (NullPointerException ex) {
      return new ArrayList<User>();
    }
    
  }
  
  public boolean updateUser(UserUpdateResults data) {
    
    User user = this.user.findOneByName(data.getName());
    user.setName(data.getName());
    user.setAdd(String.valueOf(data.getNumberOne() +data.getNumberTwo()));
    user.setSubtract(String.valueOf(data.getNumberOne() - data.getNumberTwo()));
    user.setMultiply(String.valueOf(data.getNumberOne() * data.getNumberTwo()));
    user.setDivide(String.valueOf(data.getNumberOne() / data.getNumberTwo()));
    this.user.save(user);
    return true;
    
  }

  public void insertUser(UserInsert request) {
    User user = new User();
    user.setName(request.getName());
    user.setAge(request.getAge());
    user.setAdd("");
    user.setSubtract("");
    user.setMultiply("");
    user.setDivide("");
    this.user.insert(user);
    
  }

  public void deleteUser(User request) {
    User user = this.user.findOneByName(request.getName());
    this.user.delete(user);
    
  }

}
