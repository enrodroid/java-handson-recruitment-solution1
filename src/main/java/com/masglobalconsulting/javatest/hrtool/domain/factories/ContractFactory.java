package com.masglobalconsulting.javatest.hrtool.domain.factories;

import com.masglobalconsulting.javatest.hrtool.domain.Contract;
import com.masglobalconsulting.javatest.hrtool.domain.HourlySalaryContract;
import com.masglobalconsulting.javatest.hrtool.domain.MonthlySalaryContract;
import com.masglobalconsulting.javatest.hrtool.domain.types.EContractType;

public class ContractFactory {
  
  private ContractFactory() {
    throw new IllegalStateException("ContractFactory can't be instantiated!");
  }
  
  private static Class<?> getContractType(Contract contract) {
    return contract.getClass();
  }
  
  public static boolean isHourlyContract(Contract contract) {
    return getContractType(contract).equals(HourlySalaryContract.class);
  }
  
  public static Contract createContract(EContractType type, Double hourlySalary, Double monthlySalary) {
    Contract contract;
    switch (type) {
      case HOURLY:
        contract = new HourlySalaryContract();
        contract.setSalary(contract.calcBaseSalaryFromAnnualSalary(hourlySalary));
        break;
      case MONTHLY:
        contract = new MonthlySalaryContract();
        contract.setSalary(contract.calcBaseSalaryFromAnnualSalary(monthlySalary));
        break;
      default: throw new IllegalArgumentException("No such contract type!");
    }
    contract.setName(type.getName());
    return contract;
  }
}
