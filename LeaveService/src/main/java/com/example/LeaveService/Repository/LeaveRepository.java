package com.example.LeaveService.Repository;

import com.example.LeaveService.Dto.LeaveDto;
import com.example.LeaveService.Entities.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

    Leave findByEmployeeId(Long employeeid);
//    List<Leave> findByEmployeesId(Long employeeId);;

   Leave findLeaveByuuid(String uuid);
}
