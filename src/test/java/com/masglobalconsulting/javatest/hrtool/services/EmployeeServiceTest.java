package com.masglobalconsulting.javatest.hrtool.services;

import com.masglobalconsulting.javatest.hrtool.domain.Employee;
import com.masglobalconsulting.javatest.hrtool.domain.Role;
import com.masglobalconsulting.javatest.hrtool.domain.factories.ContractFactory;
import com.masglobalconsulting.javatest.hrtool.domain.types.EContractType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceTest.class);
  
  @MockBean
  private EmployeeService employeeService;
  
  @Test
  public void getEmployeesTest() {
    LOGGER.debug("Testing Business Logic Layer: getEmployees()...");
    try {
      Role enriqueRole = new Role(0, "Support", "Support team member");
      Employee enrique = new Employee(0, enriqueRole, "Enrique F. Agudo V.",
          ContractFactory.createContract(EContractType.HOURLY, 50.0, .0));
      
      List<Employee> expectedList = Collections.singletonList(enrique);
      List<Employee> resultingList = employeeService.getEmployees();
      
      BDDMockito.given(resultingList).willReturn(expectedList);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
