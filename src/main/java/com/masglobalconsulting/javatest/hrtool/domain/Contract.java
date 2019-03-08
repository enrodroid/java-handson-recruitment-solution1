package com.masglobalconsulting.javatest.hrtool.domain;

import lombok.Data;

import java.beans.Transient;
import java.io.Serializable;

@Data
public abstract class Contract implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected Integer id;
  
  protected Double salary;
  
  protected String name;
  
  @Transient
  public abstract Double getAnnualSalary();
  
  @Transient
  public abstract Double calcBaseSalaryFromAnnualSalary(Double annualSalary);
  
  @Override
  public String toString() {
    return "Contract " + name + ": id [" + id + "], salary [" + salary + ']';
  }
}
