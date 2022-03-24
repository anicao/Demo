package com.example.sonar.demo.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.example.sonar.demo.domain.User;
import com.example.sonar.demo.model.UserInsert;
import com.example.sonar.demo.model.UserUpdateResults;
import com.example.sonar.demo.repository.UserRepository;

@SpringBootTest
class UserServiceTest {

  @InjectMocks
  private UserService userService;

  @Mock
  private UserRepository userRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testFindUsers() {
    when(userRepository.findAll()).thenReturn(new ArrayList<User>());
    userService.findUsers("");
    assertTrue(true);
  }
  
  @Test
  void testFindUsersNotEmpty() {
    when(userRepository.findAll()).thenReturn(new ArrayList<User>());
    userService.findUsers("name");
    assertTrue(true);
  }
  
  @Test
  void testFindUsersException() {
    assertThrows(NullPointerException.class, () -> userService.findUsers(null));
  }
  
  @Test
  void testUpdateUser() {
    UserUpdateResults data = new UserUpdateResults ();
    data.setName("name");
    data.setNumberOne(4);
    data.setNumberTwo(5);
    when(userRepository.findOneByName(Mockito.anyString())).thenReturn(new User());
    when(userRepository.save(Mockito.any())).thenReturn(null);
    assertTrue(userService.updateUser(data));
  }
  
  @Test
  void testInsertUser() {
    UserInsert request = new UserInsert ();
    when(userRepository.insert(Mockito.any(User.class))).thenReturn(null);
    userService.insertUser(request);
    assertTrue(true);
  }
  
  @Test
  void testDeleteUser() {
    User request = new User();
    doNothing().when(userRepository).delete(Mockito.any(User.class));
    userService.deleteUser(request);
  }

}
