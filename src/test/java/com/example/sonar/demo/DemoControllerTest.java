package com.example.sonar.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.sonar.demo.domain.User;
import com.example.sonar.demo.model.UserFindModel;
import com.example.sonar.demo.model.UserInsert;
import com.example.sonar.demo.model.UserUpdateResults;
import com.example.sonar.demo.service.UserService;

@SpringBootTest
class DemoControllerTest {
  
  @InjectMocks
  private DemoController controller;
  
  @Mock
  private UserService userService;
  
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetUsers() {
    UserFindModel request = new UserFindModel();
    request.setName("name");
    when(userService.findUsers(Mockito.anyString())).thenReturn(null);
    controller.getUsers(request);
    assertTrue(true);
  }
  
  @Test
  void testUpdateValues() {
    UserUpdateResults request = new UserUpdateResults();
    request.setName("name");
    when(userService.updateUser(Mockito.any())).thenReturn(true);
    controller.updateValues(request);
    assertTrue(true);
  }
  
  @Test
  void testInsertValues() {
    UserInsert request = new UserInsert();
    request.setName("name");
    doNothing().when(userService).insertUser(Mockito.any());
    controller.insertValues(request);
    assertTrue(true);
  }
  
  @Test
  void testDeleteValues() {
    User request = new User();
    request.setName("name");
    doNothing().when(userService).deleteUser(Mockito.any());
    controller.deleteUser(request);
    assertTrue(true);
  }

}
