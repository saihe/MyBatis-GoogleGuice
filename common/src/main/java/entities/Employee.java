package entities;

import lombok.Data;

import java.text.MessageFormat;

@Data
public class Employee {
    private Integer id;
    private String name;
    private String mail;
    private Integer departmentId;

    public String toString() {
        return MessageFormat.format(
                "ID:[{0}], name:[{1}], mail:[{2}], department_id:[{3}]"
                , id
                , name
                , mail
                , departmentId
        );
    }
}
