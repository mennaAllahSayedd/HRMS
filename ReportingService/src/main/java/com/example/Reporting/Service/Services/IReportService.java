package com.example.Reporting.Service.Services;


import com.example.Reporting.Service.DtoS.ReportDto;
import java.util.List;

public interface IReportService {

    ReportDto createReport(ReportDto reportDto);

    ReportDto updateReport(Long id, ReportDto reportDto);

    void deleteReport(Long id);

    ReportDto getReportById(Long id);

    List<ReportDto> getAllReports();
}
