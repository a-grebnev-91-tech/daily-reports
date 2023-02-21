package a.grebnev.dailyreports.repository;

import a.grebnev.dailyreports.document.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ReportRepository extends MongoRepository<Report, Long> {
    Optional<Report> findReportByReportDate(LocalDate reportDate);
}
