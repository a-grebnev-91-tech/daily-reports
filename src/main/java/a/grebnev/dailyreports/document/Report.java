package a.grebnev.dailyreports.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Report {
    @Id
    private long id;
    @Indexed(unique = true)
    private LocalDate reportDate;
    private String accident;
    private String gmo;
    private String powerSupply;
    private String apcs;
    private String spun;
    private String highway;
    private String dispatcherInspection;
    private Dispatcher dispatcher;
}
