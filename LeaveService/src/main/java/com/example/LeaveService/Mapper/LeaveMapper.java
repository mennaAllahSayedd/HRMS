package com.example.LeaveService.Mapper;

import com.example.LeaveService.Dto.LeaveDto;
import com.example.LeaveService.Entities.Leave;

public class LeaveMapper {

    public static LeaveDto mapToLeaveDto(Leave leave,LeaveDto leaveDto ){
        leaveDto.setEmployeeId(leave.getEmployeeId());
        leaveDto.setType(leave.getLeaveType());
        leaveDto.setStartDate(leave.getStartDate());
        leaveDto.setEndDate(leave.getEndDate());
        leaveDto.setReason(leave.getReason());
        return leaveDto;
    }

    public static Leave mapToLeave(LeaveDto leaveDto ,Leave leave ){
        leave.setEmployeeId(leaveDto.getEmployeeId());
        leave.setLeaveType(leaveDto.getType());
        leave.setStartDate(leaveDto.getStartDate());
        leave.setEndDate(leaveDto.getEndDate());
        leave.setReason(leaveDto.getReason());
        return leave;
    }

}
