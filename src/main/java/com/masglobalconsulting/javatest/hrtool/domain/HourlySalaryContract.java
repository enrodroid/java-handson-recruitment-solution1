package com.masglobalconsulting.javatest.hrtool.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HourlySalaryContract extends Contract {
  
  @Override
  public Double getAnnualSalary() {
    return 120 * salary * 12;
  }
}
