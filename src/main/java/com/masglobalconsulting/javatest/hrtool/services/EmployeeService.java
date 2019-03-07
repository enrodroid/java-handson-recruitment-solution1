package com.masglobalconsulting.javatest.hrtool.services;

import com.masglobalconsulting.javatest.hrtool.domain.Employee;
import com.masglobalconsulting.javatest.hrtool.exceptions.HRException;

import java.util.List;

public interface EmployeeService {

  Employee getEmployee(Integer id) throws HRException;
  
  List<Employee> getEmployees() throws HRException;
}
