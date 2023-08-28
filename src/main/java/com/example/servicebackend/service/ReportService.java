package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.ReportDto;

import java.util.List;

public interface ReportService {

    ReportDto addReport(ReportDto reportDto);

    List<ReportDto> getAllReportsByUserId(String userId);
}
