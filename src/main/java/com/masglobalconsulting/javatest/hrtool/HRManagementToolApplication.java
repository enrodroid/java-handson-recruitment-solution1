package com.masglobalconsulting.javatest.hrtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HRManagementToolApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(HRManagementToolApplication.class, args);
  }
}
