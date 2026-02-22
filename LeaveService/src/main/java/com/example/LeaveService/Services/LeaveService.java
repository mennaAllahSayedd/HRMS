package com.example.LeaveService.Services;

import com.example.LeaveService.Dto.LeaveDto;
import com.example.LeaveService.Entities.Leave;
import com.example.LeaveService.Enums.LeaveStatus;
import com.example.LeaveService.Mapper.LeaveMapper;
import com.example.LeaveService.Repository.LeaveRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveDto applyLeave(LeaveDto request) {
        Leave mappedLeave= LeaveMapper.mapToLeave(request,new Leave());
        mappedLeave.setStatus(LeaveStatus.PENDING);
        leaveRepository.save(mappedLeave);
        LeaveDto changedLeaveStatus = LeaveMapper.mapToLeaveDto(mappedLeave,new LeaveDto());
        return changedLeaveStatus;
    }

    public LeaveDto approveLeave(String uuid) {

        Leave request = getLeaveByuuid(uuid);
        request.setStatus(LeaveStatus.APPROVED);
        leaveRepository.save(request);
        LeaveDto changedLeaveStatus =  LeaveMapper.mapToLeaveDto(request,new LeaveDto());
        return changedLeaveStatus;
    }

    public LeaveDto rejectLeave(String empid) {
        Leave request = getLeaveByuuid(empid);
        request.setStatus(LeaveStatus.REJECTED);
        leaveRepository.save(request);
        LeaveDto changedLeaveStatus =  LeaveMapper.mapToLeaveDto(request,new LeaveDto());
        return changedLeaveStatus;
    }

//    public List<Leave> getEmployeeLeaves(Long empId) {
//
//        return leaveRepository.findByEmployeeId(empId);
//    }

    private Leave getLeaveByuuid(String uuid){
        return leaveRepository.findLeaveByuuid(uuid);
    }
    private Leave getLeaveByEmployeeId(Long employeeId) {
        return leaveRepository.findByEmployeeId(employeeId);

    }
}
