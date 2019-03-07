package com.masglobalconsulting.javatest.hrtool.domain.factories;

import com.masglobalconsulting.javatest.hrtool.domain.Contract;
import com.masglobalconsulting.javatest.hrtool.domain.HourlySalaryContract;
import com.masglobalconsulting.javatest.hrtool.domain.MonthlySalaryContract;
import com.masglobalconsulting.javatest.hrtool.domain.types.EContractType;

public class ContractFactory {
  
  private ContractFactory() {
    throw new IllegalStateException("Class Contract Factory!");
  }
  
  public static Contract getContractBy(EContractType type, Double hourlySalary, Double monthlySalary) {
    Contract contract;
    switch (type) {
      case HOURLY:
        contract = new HourlySalaryContract();
        contract.setSalary(hourlySalary);
        break;
      case MONTHLY:
        contract = new MonthlySalaryContract();
        contract.setSalary(monthlySalary);
        break;
      default: return null;
    }
    contract.setName(type.getName());
    return contract;
  }
  
  public static boolean isHourlyContract(Contract contract) {
    return contract.getClass().equals(HourlySalaryContract.class);
  }
}
