package mapper;

import entities.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    List<Employee> all();
    void insert(Employee employee);
    void insertList(List<Employee> employeeList);
}
