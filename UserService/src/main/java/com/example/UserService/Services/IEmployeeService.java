package com.example.UserService.Services;

import com.example.UserService.Dto.EmployeesDto;
import com.example.UserService.Dto.TrainingDto;

import java.util.List;

public interface IEmployeeService {

  EmployeesDto updateEmployee(EmployeesDto employeesDto);

  EmployeesDto createEmployee(EmployeesDto employeesDto);

  void deleteEmployee(Long employeeNum);

  EmployeesDto getEmployeeByNumber(Long employeesNum);

  List<EmployeesDto> getAllEmployees() ;

  public List<TrainingDto> fetchTrainings() ;

  String enrollEmployee(Long empId , String trainingName);
}
