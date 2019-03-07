package com.masglobalconsulting.javatest.hrtool.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
  
  private Integer id;
  
  private String name;
  
  private String description;
}
