package com.example.Reporting.Service.Mapper;


import com.example.Reporting.Service.DtoS.ReportDto;
import com.example.Reporting.Service.Entities.Report;

public class ReportMapping {

    // Convert DTO → Entity
    public static Report mapToReport(Report report,ReportDto reportDto) {
        if (reportDto == null) return null;

        report.setUuid(reportDto.getUuid());
        report.setReportName(reportDto.getReportName());
        report.setReportDescription(reportDto.getReportDescription());
        report.setCreatedBy(reportDto.getGeneratedBy());
        report.setCreatedAt(reportDto.getGeneratedAt());
        report.setReportData(reportDto.getReportData());
        return report;
    }

    // Convert Entity → DTO
    public static ReportDto mapToReportDto(ReportDto reportDto,Report report) {
        if (report == null) return null;

        reportDto.setUuid(report.getUuid());
        reportDto.setReportName(report.getReportName());
        reportDto.setReportDescription(report.getReportDescription());
        reportDto.setGeneratedBy(report.getCreatedBy());
        reportDto.setGeneratedAt(report.getCreatedAt());
        reportDto.setReportData(reportDto.getReportData());
        return reportDto;
    }


}
