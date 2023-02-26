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
    @Null(groups = OnCreate.class, message = "should be null when created")
    @NotNull(groups = OnUpdate.class, message = "could not be null when updated")
    private Long id;
    @NotNull(message = "could not be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DEFAULT_DATE_FORMAT)
    private LocalDate reportDate;
    @NotBlank(message = "could not be blank")
    private String accident;
    @NotBlank(message = "could not be blank")
    private String gmo;
    @NotBlank(message = "could not be blank")
    private String powerSupply;
    @NotBlank(message = "could not be blank")
    private String apcs;
    @NotBlank(message = "could not be blank")
    private String spun;
    @NotBlank(message = "could not be blank")
    private String highway;
    @NotBlank(message = "could not be blank")
    private String dispatcherInspection;
    @NotBlank(message = "could not be blank")
    private String dispatcher;
}
