package com.example.sonar.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.sonar.demo.domain.User;
import com.example.sonar.demo.model.UserFindModel;
import com.example.sonar.demo.model.UserInsert;
import com.example.sonar.demo.model.UserUpdateResults;
import com.example.sonar.demo.repository.UserRepository;
import com.example.sonar.demo.service.UserService;

@RestController
public class DemoController {

  @Autowired
  UserService user;

  @PostMapping("/getResults")
  public List<User> getUsers(@RequestBody UserFindModel request) {
    return user.findUsers(request.getName());
    
    
  }

  @PostMapping("/updateValues")
  public String updateValues(@RequestBody UserUpdateResults request) {
   user.updateUser(request);
   return "OK";
  }
  
  @PostMapping("/insertUser")
  public void insertValues(@RequestBody UserInsert request) {
    user.insertUser(request);
  }
  
  @PostMapping("/deleteUser")
  public void deleteUser(@RequestBody User request) {
    user.deleteUser(request);
  }

}
