import com.google.inject.Inject;
import entities.Employee;
import mapper.EmployeeMapper;

import java.util.List;

import static utils.SystemUtil.print;

public class Runner {
    @Inject
    private EmployeeMapper employeeMapper;

    public void run() {
        print("run");
        List<Employee> employeeList = employeeMapper.all();
        employeeList.forEach(e -> print(e.toString()));
    }
}
