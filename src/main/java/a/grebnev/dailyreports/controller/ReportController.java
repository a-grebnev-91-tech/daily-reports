package a.grebnev.dailyreports.controller;

import a.grebnev.dailyreports.document.Report;
import a.grebnev.dailyreports.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService service;

    @GetMapping("/reports")
    public Report getReport(
            @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("Requested report for the {}", date);
        return service.getReport(date);
    }

    @PostMapping("/reports")
    public Report createReport(@RequestBody ReportDto dto) {

    }
}
