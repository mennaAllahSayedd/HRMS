package com.example.Reporting.Service.Controllers;

import com.example.Reporting.Service.DtoS.ReportDto;
import com.example.Reporting.Service.Services.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@Slf4j
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @Operation(summary = "Create a new report")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Report created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReportDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<ReportDto> createReport(@Valid @RequestBody ReportDto reportDto) {

        try {
            log.info("REST request to create report: {}", reportDto.getReportName());

            ReportDto created = reportService.createReport(reportDto);

            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }   catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Update an existing report")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Report updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReportDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Report not found",
                    content = @Content)
    })
    @PutMapping("/{id}")
 public ResponseEntity<ReportDto> updateReport(@PathVariable Long id, @Valid @RequestBody ReportDto reportDto) {

        try{
        log.info("REST request to update report with id: {}", id);

        ReportDto updated = reportService.updateReport(id, reportDto);

        return ResponseEntity.ok(updated);
        }   catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Delete a report by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Report deleted successfully",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Report not found",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
      try{
        log.warn("REST request to delete report with id: {}", id);

        reportService.deleteReport(id);

        return ResponseEntity.noContent().build();
      }   catch (RuntimeException e) {
          throw new RuntimeException(e);
      }
    }

    @Operation(summary = "Get a report by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Report found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReportDto.class))),
            @ApiResponse(responseCode = "404", description = "Report not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ReportDto> getReportById(@PathVariable Long id) {
     try {
         log.info("REST request to get report with id: {}", id);

         return ResponseEntity.ok(reportService.getReportById(id));
     }   catch (RuntimeException e) {
         throw new RuntimeException(e);
     }
    }

    @Operation(summary = "Get all reports")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reports fetched successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReportDto.class)))
    })
    @GetMapping
    public ResponseEntity<List<ReportDto>> getAllReports() {
    try {
        log.info("REST request to get all reports");

        return ResponseEntity.ok(reportService.getAllReports());
    }   catch (RuntimeException e) {
        throw new RuntimeException(e);
    }
    }
}
