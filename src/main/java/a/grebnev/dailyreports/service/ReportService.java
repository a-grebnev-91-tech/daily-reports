package a.grebnev.dailyreports.service;

import a.grebnev.dailyreports.document.Report;
import a.grebnev.dailyreports.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository repository;

    public Report findReport(LocalDate date) {
        return null;
    }
}
