package a.grebnev.dailyreports.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

import static a.grebnev.dailyreports.util.Constants.DEFAULT_DATE_FORMAT;

public class ReportDto {

    @Null(groups = PostInfo.class)
    private long id;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DEFAULT_DATE_FORMAT )
    private LocalDate reportDate;

}
