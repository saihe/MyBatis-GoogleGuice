package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String mail;
    private String departmentId;
    private String entryDatetime;

    public String toString() {
        return MessageFormat.format(
                "ID:[{0}], name:[{1}], mail:[{2}], department_id:[{3}], entry_datetime:[{4}]"
                , id
                , name
                , mail
                , departmentId
                , entryDatetime
        );
    }
}
