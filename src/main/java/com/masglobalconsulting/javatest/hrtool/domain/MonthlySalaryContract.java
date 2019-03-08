package com.masglobalconsulting.javatest.hrtool.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MonthlySalaryContract extends Contract {
  private static final long serialVersionUID = 1L;
  
  @Override
  public Double getAnnualSalary() {
    return salary * 12;
  }
  
  @Override
  public Double calcBaseSalaryFromAnnualSalary(Double annualSalary) {
    double baseSalary = annualSalary / 12;
    return baseSalary > 0 ? Math.round(baseSalary * 100) / 100D : 0;
  }
}
