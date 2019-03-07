package com.masglobalconsulting.javatest.hrtool.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class Contract implements Serializable {
  
  protected Integer id;
  
  protected Double salary;
  
  protected String name;
  
  public abstract Double getAnnualSalary();
  
  @Override
  public String toString() {
    return "Contract " + name + ": id [" + id + "], salary [" + salary + ']';
  }
}
