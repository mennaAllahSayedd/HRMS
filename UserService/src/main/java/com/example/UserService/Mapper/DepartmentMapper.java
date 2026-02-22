package com.example.UserService.Mapper;

import com.example.UserService.Dto.DepartmentsDto;
import com.example.UserService.Entities.Department;

public  class DepartmentMapper {

    public static DepartmentsDto mapToDepartmentsDto(Department department,DepartmentsDto departmentsDto )
    {
      departmentsDto.setName(department.getName());
      departmentsDto.setDepartment_Number(department.getDepartmentNumber());
      departmentsDto.setDescription(department.getDescription());
       return departmentsDto;
    }

    public static Department mapToDepartments(DepartmentsDto departmentsDto ,Department department )
    {
        department.setName(departmentsDto.getName());
        department.setDepartmentNumber(departmentsDto.getDepartment_Number());
        department.setDescription(departmentsDto.getDescription());
        return department;
    }


}
