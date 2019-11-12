import com.google.inject.Inject;
import entities.Employee;
import mapper.EmployeeMapper;

import java.util.List;

import static utils.utils.SystemUtil.print;


public class Runner {
    @Inject
    private EmployeeMapper employeeMapper;

    public void run() {
        print("run");
        List<Employee> employeeList = employeeMapper.all();
        print("=========複数=========");
        employeeList.forEach(e -> print(e.toString()));

        Employee employee = employeeMapper.one();
        print("=========単体=========");
        print(employee.toString());

        employeeList = employeeMapper.selectAny();
        print("=========select any=========");
        employeeList.forEach(e -> print(e.toString()));

        employee = employeeMapper.selectOne(1);
        print("=========select one=========");
        print(employee.toString());
    }
}
