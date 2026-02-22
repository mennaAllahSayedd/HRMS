package com.example.Reporting.Service.Services;


import com.example.Reporting.Service.DtoS.ReportDto;
import com.example.Reporting.Service.Entities.Report;
import com.example.Reporting.Service.Exceptions.NoSuchReportFoundException;
import com.example.Reporting.Service.Mapper.ReportMapping;
import com.example.Reporting.Service.Repositories.ReportRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ReportService implements IReportService {

    private final ReportRepo reportRepo;


    @Override
    public ReportDto createReport(ReportDto reportDto) {

        log.info("Creating new report: {}", reportDto.getReportName());

        reportDto.setGeneratedAt(LocalDateTime.now());

        Report report = ReportMapping.mapToReport(new Report() ,reportDto);
        Report saved = reportRepo.save(report);

        log.info("Report created successfully with id: {}", saved.getId());

        return ReportMapping.mapToReportDto(new ReportDto(),saved);
    }

    @Override
    public ReportDto updateReport(Long id, ReportDto reportDto) {

        log.info("Updating report with id: {}", id);

        Report existing = reportRepo.findById(id)
                .orElseThrow(() -> new NoSuchReportFoundException("Report not found with id: " + id));
//
//        ReportMapper.updateEntity(existing, reportDto);
//        Report updated = reportRepo.save(existing);
//
//        log.info("Report updated successfully with id: {}", updated.getId());

//        return ReportMapper.toDto(updated);
        return null;
    }

    @Override
    public void deleteReport(Long id) {

        log.warn("Deleting report with id: {}", id);

        Report existing = reportRepo.findById(id)
                .orElseThrow(() -> new NoSuchReportFoundException("Report not found with id: " + id));

        reportRepo.delete(existing);

        log.warn("Report deleted successfully with id: {}", id);
    }

    @Override
    public ReportDto getReportById(Long id) {

        log.info("Fetching report with id: {}", id);

        Report report = reportRepo.findById(id)
                .orElseThrow(() -> new NoSuchReportFoundException("Report not found with id: " + id));

        return ReportMapping.mapToReportDto(new ReportDto(),report);
    }

    @Override
    public List<ReportDto> getAllReports() {

//        log.info("Fetching all reports");
//
//        return reportRepo.findAll()
//                .stream()
//                .map(ReportMapping::mapToReportDto)
//                .toList();
        return null;
    }
}
