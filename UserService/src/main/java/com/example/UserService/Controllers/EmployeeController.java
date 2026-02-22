package com.example.UserService.Controllers;

import com.example.UserService.Dto.EmployeesDto;
import com.example.UserService.Dto.TrainingDto;
import com.example.UserService.Services.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;

    @Operation(summary = "Create a new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeesDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<EmployeesDto> createEmployee(
            @RequestBody EmployeesDto employeesDto) {

            EmployeesDto createdEmployee =
                    employeeService.createEmployee(employeesDto);
        log.info("Employees Created Successfully.");

        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);

    }

    @GetMapping("/trainings")
    public ResponseEntity<List<TrainingDto>> getAvailableTrainings() {
        List<TrainingDto> trianings = employeeService.fetchTrainings();
        return ResponseEntity.ok(trianings) ;

    }

    @GetMapping("/resource")
    public ResponseEntity<String> enrollEmployeeToTraining
            (@RequestParam Long empId , @RequestParam String trainingName){
        return ResponseEntity.ok(employeeService.enrollEmployee(empId,trainingName));

    }

    @Operation(summary = "Update an existing employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeesDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content)
    })

    @PutMapping
    public ResponseEntity<EmployeesDto> updateEmployee(@RequestBody EmployeesDto employeesDto) {
        try {
            EmployeesDto updatedEmployee =
                    employeeService.updateEmployee(employeesDto);
            log.info("Employees Updated Successfully.");

            return ResponseEntity.ok(updatedEmployee);
        }catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Get an employee by employee number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeesDto.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content)
    })
    @GetMapping("/{employeeNumber}")
    public ResponseEntity<EmployeesDto> getEmployeeByNumber(@PathVariable Long employeeNumber) {
        try {
            EmployeesDto employee =
                    employeeService.getEmployeeByNumber(employeeNumber);
            log.info("Employee Fetched Successfully.");

            return ResponseEntity.ok(employee);
        }catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @Operation(summary = "Delete an employee by employee number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Employee deleted successfully",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content)
    })
    @DeleteMapping("/{employeeNumber}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeNumber) {
        try {
            employeeService.deleteEmployee(employeeNumber);
            log.info("Employee Deleted Successfully.");

            return ResponseEntity.noContent().build();
        }catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @Operation(summary = "get all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Employee Fetched successfully",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employees are not found",
                    content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<EmployeesDto>> getAllEmployees() {
        try {
          List<EmployeesDto> employees=  employeeService.getAllEmployees();
          log.info("Employees Fetched Successfully.");
            return ResponseEntity.ok(employees);

        }catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
     }
}
