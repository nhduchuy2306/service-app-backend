package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.ReportDto;
import com.example.servicebackend.model.entity.Report;
import com.example.servicebackend.model.mapper.ReportMapper;
import com.example.servicebackend.repository.ReportRepository;
import com.example.servicebackend.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    public ReportDto addReport(ReportDto reportDto) {
        Report report = ReportMapper.INSTANCE.toEntity(reportDto);
        Report newReport = reportRepository.save(report);
        return ReportMapper.INSTANCE.toDto(newReport);
    }

    @Override
    public List<ReportDto> getAllReportsByUserId(String userId) {
        List<Report> reports = reportRepository.findAllByUserId(userId);
        return reports.stream().map(ReportMapper.INSTANCE::toDto).collect(Collectors.toList());
    }
}
