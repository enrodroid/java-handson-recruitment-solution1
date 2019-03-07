package com.masglobalconsulting.javatest.hrtool.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MonthlySalaryContract extends Contract {
  
  @Override
  public Double getAnnualSalary() {
    return salary * 12;
  }
}
