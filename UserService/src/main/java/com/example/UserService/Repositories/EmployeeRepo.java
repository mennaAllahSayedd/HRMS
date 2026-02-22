package com.example.UserService.Repositories;

import com.example.UserService.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmployeeNumber(Long employeeNumber);

}
