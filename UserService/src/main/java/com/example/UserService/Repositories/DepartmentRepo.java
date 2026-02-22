package com.example.UserService.Repositories;

import com.example.UserService.Entities.Department;
import com.example.UserService.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
    Optional<Department> findByDepartmentNumber(Long employeeNumber);

}
