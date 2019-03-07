package com.masglobalconsulting.javatest.hrtool.dataaccess;

import com.masglobalconsulting.javatest.hrtool.dtos.EmployeeDto;
import com.masglobalconsulting.javatest.hrtool.exceptions.HRDaoException;

import java.util.List;

public interface EmployeeDao {
  
  EmployeeDto findById(Integer id) throws HRDaoException;
  
  List<EmployeeDto> findAll() throws HRDaoException;
}
