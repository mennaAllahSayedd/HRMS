package com.example.LeaveService.Controllers;

import com.example.LeaveService.Dto.LeaveDto;
import com.example.LeaveService.Entities.Leave;
import com.example.LeaveService.Services.LeaveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@AllArgsConstructor
@Validated
public class LeaveController {

    private final LeaveService leaveService;

    @Operation(summary = "Apply for a new leave")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Leave applied successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Leave.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<LeaveDto> apply(@RequestBody @Valid LeaveDto request) {
        try{
            return ResponseEntity.ok(leaveService.applyLeave(request));
        }catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @Operation(summary = "Approve a leave by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Leave approved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Leave.class))),
            @ApiResponse(responseCode = "404", description = "Leave not found",
                    content = @Content)
    })
    @PutMapping("/{id}/approve")
    public ResponseEntity<LeaveDto> approve(@PathVariable @NotNull String uuid) {
        try {
            return ResponseEntity.ok(leaveService.approveLeave(uuid));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Reject a leave by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Leave rejected successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Leave.class))),
            @ApiResponse(responseCode = "404", description = "Leave not found",
                    content = @Content)
    })
    @PutMapping("/{id}/reject")
    public ResponseEntity<LeaveDto> reject(@PathVariable String id) {
        try{
        return ResponseEntity.ok(leaveService.rejectLeave(id));
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

//    @Operation(summary = "Get all leaves for a specific employee by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Leaves fetched successfully",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Leave.class))),
//            @ApiResponse(responseCode = "404", description = "Employee or leaves not found",
//                    content = @Content)
//    })
//
//    @GetMapping("/employee/{id}")
//    public ResponseEntity<List<Leave>> getEmployeeLeaves(@PathVariable Long id) {
//        return ResponseEntity.ok(leaveService.getEmployeeLeaves(id));
//    }
}
