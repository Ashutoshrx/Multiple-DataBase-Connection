package com.jarvis.mds.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ToString
@Getter
@Setter
@ConfigurationProperties(prefix = "test.student")
@Component
public class Student {
  private String id;
  private String firstName;
  private String lastName;
}


