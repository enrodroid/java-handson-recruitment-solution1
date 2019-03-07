package com.masglobalconsulting.javatest.hrtool.services.impls;

import com.masglobalconsulting.javatest.hrtool.dataaccess.EmployeeDao;
import com.masglobalconsulting.javatest.hrtool.domain.Employee;
import com.masglobalconsulting.javatest.hrtool.dtos.EmployeeDto;
import com.masglobalconsulting.javatest.hrtool.exceptions.HRDaoException;
import com.masglobalconsulting.javatest.hrtool.exceptions.HRException;
import com.masglobalconsulting.javatest.hrtool.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
  
  private EmployeeDao employeeDao;
  
  @Autowired
  public EmployeeServiceImpl(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }
  
  @Override
  public Employee getEmployee(Integer id) throws HRException {
    try {
      return new Employee(employeeDao.findById(id));
    } catch (HRDaoException e) {
      LOGGER.error("Exception was triggered trying to find employee with id " + id, e);
      throw new HRException("Employee not found!");
    }
  }
  
  @Override
  public List<Employee> getEmployees() throws HRException {
    try {
      List<Employee> employees = new LinkedList<>();
      List<EmployeeDto> employeeDtos = employeeDao.findAll();
      employeeDtos.forEach(eDto -> employees.add(new Employee(eDto)));
      return employees;
    } catch (HRDaoException e) {
      LOGGER.error("Exception was triggered loading all employees!", e);
      throw new HRException("Wasn't possible to retrieve all employees!");
    }
  }
}
