import dao.EmployeeDao;
import entities.Employee;
import utils.DaoUtil;

import java.util.List;

import static utils.SystemUtil.print;

public class Runner {
    public void run() {
        EmployeeDao employeeDao = DaoUtil.getDao(EmployeeDao.class);
        List<Employee> employeeList = employeeDao.all();
        employeeList.forEach(e -> print(e.toString()));
    }
}
