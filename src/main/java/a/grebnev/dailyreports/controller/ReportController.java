package a.grebnev.dailyreports.controller;

import a.grebnev.dailyreports.validation.OnUpdate;
import a.grebnev.dailyreports.dto.ReportDto;
import a.grebnev.dailyreports.service.ReportService;
import a.grebnev.dailyreports.validation.OnCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService service;

    @GetMapping("/reports")
    public ReportDto getReport(
            @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("Requested report for the {}", date);
        return service.getReport(date);
    }

    //TODO подумать над валидацией отчетов по дате (в прошлом? в будущем?)
    @PostMapping("/reports")
    public ReportDto createReport(@RequestBody @Validated(OnCreate.class) ReportDto dto) {
        log.info("Posted new report for the {}", dto.getReportDate());
        return service.createReport(dto);
    }

    @PutMapping("/reports")
    public ReportDto updateReport(@RequestBody @Validated(OnUpdate.class) ReportDto dto) {
        log.info("Updated report for the {}", dto.getReportDate());
        return service.updateReport(dto);
    }
}
