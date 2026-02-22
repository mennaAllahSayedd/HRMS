package com.example.Reporting.Service.Repositories;

import com.example.Reporting.Service.Entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report,Long> {

}
