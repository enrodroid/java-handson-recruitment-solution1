package com.masglobalconsulting.javatest.hrtool.dtos;

import com.masglobalconsulting.javatest.hrtool.domain.Contract;
import com.masglobalconsulting.javatest.hrtool.domain.Employee;
import com.masglobalconsulting.javatest.hrtool.domain.Role;
import com.masglobalconsulting.javatest.hrtool.domain.factories.ContractFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto implements Serializable {
  
  private Integer id;
  
  private String name;
  
  private Integer roleId;
  
  private String roleName;
  
  private String roleDescription;
  
  private String contractTypeName;
  
  private Integer hourlySalary;
  
  private Integer monthlySalary;
  
  public EmployeeDto(Employee employee) {
    id = employee.getId();
    name = employee.getFullName();
    
    Role role = employee.getRole();
    if (Objects.nonNull(role)) {
      roleId = role.getId();
      roleName = role.getName();
      roleDescription = role.getDescription();
    }
    
    Contract contract = employee.getContract();
    if (Objects.nonNull(contract)) {
      contractTypeName = contract.getName();
      if (ContractFactory.isHourlyContract(contract)) {
        hourlySalary = contract.getSalary().intValue();
      } else {
        monthlySalary = contract.getSalary().intValue();
      }
    }
  }
}
