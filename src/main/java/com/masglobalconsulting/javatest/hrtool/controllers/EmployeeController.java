package com.masglobalconsulting.javatest.hrtool.controllers;

import com.masglobalconsulting.javatest.hrtool.domain.Employee;
import com.masglobalconsulting.javatest.hrtool.exceptions.HRException;
import com.masglobalconsulting.javatest.hrtool.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr-api/employees")
public class EmployeeController {
  
  private EmployeeService employeeService;
  
  @Autowired
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }
  
  @CrossOrigin
  @GetMapping("/")
  public List<Employee> getEmployees() throws HRException {
    return employeeService.getEmployees();
  }
  
  @CrossOrigin
  @GetMapping("/{employeeId}")
  public Employee getEmployeeById(@PathVariable Integer employeeId) throws HRException {
    return employeeService.getEmployee(employeeId);
  }
}
