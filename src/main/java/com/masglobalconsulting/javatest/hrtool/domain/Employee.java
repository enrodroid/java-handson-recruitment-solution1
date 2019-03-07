package com.masglobalconsulting.javatest.hrtool.domain;

import com.masglobalconsulting.javatest.hrtool.domain.factories.ContractFactory;
import com.masglobalconsulting.javatest.hrtool.domain.types.EContractType;
import com.masglobalconsulting.javatest.hrtool.dtos.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
  
  private Integer id;
  
  private Role role;
  
  private String fullName;
  
  private Contract contract;
  
  public Employee(EmployeeDto employeeDto) {
    this.id = employeeDto.getId();
    this.role = new Role(employeeDto.getRoleId(), employeeDto.getRoleName(), employeeDto.getRoleDescription());
    this.fullName = employeeDto.getName();
    
    EContractType contractType = EContractType.getContractTypeByName(employeeDto.getContractTypeName());
    if (Objects.nonNull(contractType)) {
      this.contract = ContractFactory.getContractBy(contractType, employeeDto.getHourlySalary().doubleValue(),
          employeeDto.getMonthlySalary().doubleValue());
    }
  }
}
