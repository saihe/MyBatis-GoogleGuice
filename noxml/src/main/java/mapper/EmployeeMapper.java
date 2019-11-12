package mapper;

import entities.Employee;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.scripting.freemarker.FreeMarkerLanguageDriver;

import java.util.List;

public interface EmployeeMapper {
    @Select("select id, name, mail, department_id as departmentId from employee")
    List<Employee> all();

    @Select("select id, name, mail, department_id as departmentId from employee where id = 1")
    Employee one();

    @Lang(FreeMarkerLanguageDriver.class)
    @Select("sql/employee/select.ftl")
    List<Employee> selectAny();

    @Lang(FreeMarkerLanguageDriver.class)
    @Select("sql/employee/select.ftl")
    Employee selectOne(@Param("id") Integer id);
}
