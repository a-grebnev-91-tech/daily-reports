package a.grebnev.dailyreports.dto;

import a.grebnev.dailyreports.validation.OnCreate;
import a.grebnev.dailyreports.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

import static a.grebnev.dailyreports.util.Constants.DEFAULT_DATE_FORMAT;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    @Null(groups = OnCreate.class)
    @NotNull(groups = OnUpdate.class)
    private Long id;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DEFAULT_DATE_FORMAT)
    private LocalDate reportDate;
    @NotBlank
    private String accident;
    @NotBlank
    private String gmo;
    @NotBlank
    private String powerSupply;
    @NotBlank
    private String apcs;
    @NotBlank
    private String spun;
    @NotBlank
    private String highway;
    @NotBlank
    private String dispatcherInspection;
    @NotBlank
    private String dispatcher;
}
