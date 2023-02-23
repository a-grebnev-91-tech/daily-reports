package a.grebnev.dailyreports.service;

import a.grebnev.dailyreports.document.Report;
import a.grebnev.dailyreports.dto.ReportDto;
import a.grebnev.dailyreports.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository repository;

    public ReportDto getReport(LocalDate date) {
        throw new RuntimeException("not impl");
    }

    public ReportDto createReport(ReportDto dto) {
        throw new RuntimeException("not impl");
    }

    public ReportDto updateReport(ReportDto dto) {
        throw new RuntimeException("not impl");
    }
}
