package com.example.UserService.Mapper;

import com.example.UserService.Dto.EmployeesDto;
import com.example.UserService.Entities.Employee;

public class EmployeeMapper {

    public static EmployeesDto mapToEmployeesDto(EmployeesDto employeesDto, Employee employee){

        employeesDto.setEmployeeNumber(employee.getEmployeeNumber());
        employeesDto.setFirstName(employee.getFirstName());
        employeesDto.setLastName(employee.getLastName());
        employeesDto.setEmail(employee.getEmail());
        employeesDto.setAge(employee.getAge());
        employeesDto.setFirstName(employee.getFirstName());
        employeesDto.setPhone(employee.getPhone());
        employeesDto.setJobTile(employee.getJobTile());
        employeesDto.setManagerId(employee.getManagerId());
        employeesDto.setDepartmentId(employee.getDepartmentId());

        return employeesDto;
    }

    public static Employee mapToEmployees( Employee employee,EmployeesDto employeesDto){

        employee.setEmployeeNumber(employeesDto.getEmployeeNumber());
        employee.setFirstName(employeesDto.getFirstName());
        employee.setLastName(employeesDto.getLastName());
        employee.setEmail(employeesDto.getEmail());
        employee.setAge(employeesDto.getAge());
        employee.setFirstName(employeesDto.getFirstName());
        employee.setPhone(employeesDto.getPhone());
        employee.setJobTile(employeesDto.getJobTile());
        employee.setManagerId(employeesDto.getManagerId());
        employee.setDepartmentId(employeesDto.getDepartmentId());

        return employee;
    }

}
