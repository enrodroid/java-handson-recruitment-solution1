package com.masglobalconsulting.javatest.hrtool.dataaccess.impls;

import com.masglobalconsulting.javatest.hrtool.dataaccess.EmployeeDao;
import com.masglobalconsulting.javatest.hrtool.dtos.EmployeeDto;
import com.masglobalconsulting.javatest.hrtool.exceptions.HRDaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);
  
  private static final String REST_API_URL = "datasource.rest.api.url";
  
  private final RestTemplate restTemplate;
  
  private final String datasourceApiUrl;
  
  private List<EmployeeDto> employeesData;
  
  private List<EmployeeDto> fetchDataFromRemoteApi() {
    LOGGER.debug("Fetching employee data from an external API from: {}", datasourceApiUrl);
    
    ResponseEntity<EmployeeDto[]> response = restTemplate.getForEntity(datasourceApiUrl, EmployeeDto[].class);
    EmployeeDto[] employeeData = response.getBody();
    
    if (Objects.nonNull(employeeData)) {
      LOGGER.debug("Found {} employees", employeeData.length);
      return Arrays.asList(employeeData);
    }
    return Collections.emptyList();
  }
  
  private void checkDataLoadStatus() {
    if (Objects.isNull(employeesData) || employeesData.equals(Collections.emptyList())) {
      employeesData = fetchDataFromRemoteApi();
    }
  }
  
  @Autowired
  public EmployeeDaoImpl(RestTemplate restTemplate, Environment environment) {
    this.restTemplate = restTemplate;
    this.datasourceApiUrl = environment.getRequiredProperty(REST_API_URL);
  }
  
  @Override
  public EmployeeDto findById(Integer id) throws HRDaoException {
    LOGGER.debug("Looking for employee with id '{}'...", id);
    try {
      checkDataLoadStatus();
      return employeesData.stream()
          .filter(e -> e.getId().equals(id))
          .findFirst()
          .orElse(null);
    } catch (Exception e) {
      LOGGER.error("Datasource searching for employee with id '" + id + "' has fail!", e);
      throw new HRDaoException("Remote data loading for employee with id " + id + " has fail!");
    }
  }
  
  @Override
  public List<EmployeeDto> findAll() throws HRDaoException {
    LOGGER.debug("Getting all employees from origin...");
    try {
      checkDataLoadStatus();
      return employeesData;
    } catch (Exception e) {
      LOGGER.error("Datasource loading execution has fail!", e);
      throw new HRDaoException("Remote data loading for all employees has fail!");
    }
  }
}
