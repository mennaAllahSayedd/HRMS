package com.example.UserService.Services;

import com.example.UserService.Client.TrainingClient;
import com.example.UserService.Dto.EmployeesDto;
import com.example.UserService.Dto.TrainingDto;
import com.example.UserService.Entities.Employee;
import com.example.UserService.Exceptions.EmployeeAlreadyExistsException;
import com.example.UserService.Exceptions.NoSuchEmployeeExistsException;
import com.example.UserService.Mapper.EmployeeMapper;
import com.example.UserService.Repositories.EmployeeRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService{

    EmployeeRepo employeeRepo;
    TrainingClient trainingClient;

    @Override
    public List<TrainingDto> fetchTrainings() {
        return trainingClient.getAvailableTrainings();
//        return trainingClient.getAvailableTrainings()
//                .stream()
//                .map(TrainingDto::getTitle)
//                .toList();
    }


    @Override
    public String enrollEmployee(Long empId , String trainingName){
        if(trainingClient.isEmployeeEnrolled(empId,trainingName)){
            trainingClient.enrollEmployee(empId,trainingName);

            log.info("Employee Enrolled To A New Training");
            return "Employee Enrolled Successfully ";

        }else{
            return "The Employee Already Enrolled To This Training";
        }
    }

    @Override
    public EmployeesDto createEmployee(EmployeesDto employeesDto){

        Employee employee = EmployeeMapper.mapToEmployees(new Employee(),employeesDto);
        Optional<Employee> currEmp =  employeeRepo.findByEmployeeNumber(employeesDto.getEmployeeNumber());

        if(currEmp.isPresent()){
            log.warn("Employee Already Exists");
            throw new EmployeeAlreadyExistsException("Employee Already Exists");
        }

        Employee newEmployee = employeeRepo.save(employee);
        log.info("Employee Create Successfully.");
        return EmployeeMapper.mapToEmployeesDto(new EmployeesDto(),newEmployee);

    }

    @Override
    public void deleteEmployee(Long employeeNum){

       Employee employee = employeeRepo.findByEmployeeNumber(employeeNum).orElseThrow(
               () -> new NoSuchEmployeeExistsException("This Employee Not Found")
       );
      employeeRepo.deleteById(employee.getId());

   }

    @Override
    public EmployeesDto updateEmployee(EmployeesDto employeesDto) {

        Employee employee = employeeRepo
                .findByEmployeeNumber(employeesDto.getEmployeeNumber())
                .orElseThrow(() -> new NoSuchEmployeeExistsException("Employee Not Found"));

        Employee updatedEmployee =
                EmployeeMapper.mapToEmployees(employee, employeesDto);

        Employee savedEmployee = employeeRepo.save(updatedEmployee);
        log.info("Employee Updated Successfully.");

        return EmployeeMapper.mapToEmployeesDto(
                new EmployeesDto(), savedEmployee);
    }
   @Override
    public EmployeesDto  getEmployeeByNumber(Long employeesNum){

       Employee emp=  employeeRepo.findByEmployeeNumber(employeesNum).orElseThrow(
                () -> new NoSuchEmployeeExistsException("Employee Not Found")
        );;

       EmployeesDto mappedEmp= EmployeeMapper.mapToEmployeesDto(new EmployeesDto(),emp);
        return mappedEmp;
    }

   @Override
    public List<EmployeesDto> getAllEmployees() {

        return employeeRepo.findAll()
                .stream()
                .map(emp -> EmployeeMapper.mapToEmployeesDto(new EmployeesDto(),emp))
                .collect(Collectors.toList());

    }

}
