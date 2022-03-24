package com.example.sonar.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "users")
public class User {
  
  @Id
  private String id;
  private String name;
  private String age;
  private String add;
  private String subtract;
  private String multiply;
  private String divide;
  

}
