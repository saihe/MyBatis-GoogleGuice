package mapper;

import entities.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper {
    @Select("select id, name, mail, department_id from employee")
    List<Employee> all();
}
