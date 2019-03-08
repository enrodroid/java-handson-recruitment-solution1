package com.masglobalconsulting.javatest.hrtool.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HourlySalaryContract extends Contract {
  private static final long serialVersionUID = 1L;
  
  @Override
  public Double getAnnualSalary() {
    // 120 * salary * 12
    return salary * 1440;
  }
  
  @Override
  public Double calcBaseSalaryFromAnnualSalary(Double annualSalary) {
    double baseSalary = annualSalary / 1440;
    return baseSalary > 0 ? Math.round(baseSalary * 100) / 100D : 0;
  }
}
