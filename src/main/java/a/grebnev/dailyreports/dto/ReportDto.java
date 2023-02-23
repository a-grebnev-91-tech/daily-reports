package a.grebnev.dailyreports.dto;

import a.grebnev.dailyreports.validation.OnCreate;
import a.grebnev.dailyreports.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

import static a.grebnev.dailyreports.util.Constants.DEFAULT_DATE_FORMAT;

@Getter
@RequiredArgsConstructor
public class ReportDto {
    @Null(groups = OnCreate.class)
    @NotNull(groups = OnUpdate.class)
    private final long id;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DEFAULT_DATE_FORMAT )
    private final LocalDate reportDate;
    @NotBlank
    private final String accident;
    @NotBlank
    private final String gmo;
    @NotBlank
    private final String powerSupply;
    @NotBlank
    private final String APCS;
    @NotBlank
    private final String SPUN;
    @NotBlank
    private final String highway;
    @NotBlank
    private final String dispatcherInspection;
    @NotBlank
    private final String dispatcher;
}
