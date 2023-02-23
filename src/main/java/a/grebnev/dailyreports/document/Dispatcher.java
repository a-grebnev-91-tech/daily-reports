package a.grebnev.dailyreports.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Dispatcher {
    @Id
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;

    @Override
    public String toString() {
        return lastName + " " + firstName.charAt(0) + '.' + middleName.charAt(0) + '.';
    }
}